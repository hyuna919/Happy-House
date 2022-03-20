package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.Qna;
import com.ssafy.happyhouse.util.PageNavigation;


@Mapper
public interface QnaDao {
	public List<Qna> listArticle(Page page) throws SQLException;
	public int getTotalCount(Page page) throws SQLException;
	public Qna getArticle(int articleno) throws SQLException;
	
	public int writeArticle(Qna qna) throws SQLException;
	public int modifyArticle(Qna qna) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;

	public int writeAnswer(Qna qna) throws SQLException;
	public int modifyAnswer(Qna qna) throws SQLException;
	public int deleteAnswer(int articleno) throws SQLException;

	public void updateHit(int articleno) throws SQLException;
}
