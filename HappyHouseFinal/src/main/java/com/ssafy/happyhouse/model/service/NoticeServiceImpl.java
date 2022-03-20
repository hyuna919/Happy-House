package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dao.NoticeDao;
import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao dao;
	
	@Override
	public PageNavigation makePageNavigation(Page page) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(page.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = dao.getTotalCount(page);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / page.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = page.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < page.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public List<Notice> listArticle(Page page) throws Exception {
		int start = page.getPg() == 0 ? 0 : (page.getPg() - 1) * page.getSpp();
		page.setStart(start);
		return dao.listArticle(page);
	}

	@Override
	public Notice getArticle(int no) throws Exception {
		return dao.getArticle(no);
	}

	@Override
	public boolean writeArticle(Notice notice) throws Exception {
		if(notice.getSubject()==null || notice.getContent()==null) {
			throw new Exception();
		}
		return dao.writeArticle(notice) ==1;
	}

	@Override
	public void updateHit(int no) throws Exception {
		dao.updateHit(no);
	}

	@Override
	@Transactional
	public boolean modifyArticle(Notice notice) throws Exception {
		return dao.modifyArticle(notice)==1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int no) throws Exception {
		return dao.deleteArticle(no)==1;
	}

}
