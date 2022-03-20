package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dao.QnaDao;
import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.Qna;
import com.ssafy.happyhouse.util.PageNavigation;


@Service
public class QnaServiceImple implements QnaService {
	
	@Autowired
	private QnaDao dao;

	@Override
	public boolean writeArticle(Qna qna) throws Exception {
		if(qna.getSubject() == null || qna.getContent() == null) {
			throw new Exception();
		}
		return dao.writeArticle(qna) == 1;
	}

	@Override
	public List<Qna> listArticle(Page page) throws Exception {
		int start = page.getPg() == 0 ? 0 : (page.getPg() - 1) * page.getSpp();
		page.setStart(start);
		return dao.listArticle(page);
	}

	@Override
	public Qna getArticle(int articleno) throws Exception {
		return dao.getArticle(articleno);
	}
	
	@Override
	public void updateHit(int articleno) throws Exception {
		dao.updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(Qna qna) throws Exception {
		return dao.modifyArticle(qna) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return dao.deleteArticle(articleno) == 1;
	}
	

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
	public boolean writeAnswer(Qna qna) throws Exception {
		if(qna.getSubject() == null || qna.getContent() == null) {
			throw new Exception();
		}
		System.out.println("--------------------"+ qna.toString());
		return dao.writeAnswer(qna) == 1;
	}

	@Override
	public boolean modifyAnswer(Qna qna) throws Exception {
		return dao.modifyAnswer(qna) == 1;
	}

	@Override
	public boolean deleteAnswer(int articleno) throws Exception {
		return dao.deleteAnswer(articleno) == 1;
	}
}