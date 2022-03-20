package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.Qna;
import com.ssafy.happyhouse.util.PageNavigation;

public interface QnaService {
	public PageNavigation makePageNavigation(Page page) throws Exception;
	
	public List<Qna> listArticle(Page page) throws Exception;
	public Qna getArticle(int articleno) throws Exception;

	public boolean writeArticle(Qna qna) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(Qna qna) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
	
	public boolean writeAnswer(Qna qna) throws Exception;
	public boolean modifyAnswer(Qna qna) throws Exception;
	public boolean deleteAnswer(int articleno) throws Exception;
}
