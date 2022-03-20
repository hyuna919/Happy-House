package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.util.PageNavigation;

public interface NoticeService {

public PageNavigation makePageNavigation(Page page) throws Exception;
	
	public List<Notice> listArticle(Page page) throws Exception;
	public Notice getArticle(int no) throws Exception;

	public boolean writeArticle(Notice notice) throws Exception;
	public void updateHit(int no) throws Exception;
	public boolean modifyArticle(Notice notice) throws Exception;
	public boolean deleteArticle(int no) throws Exception;
	
	
}
