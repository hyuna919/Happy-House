package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.Notice;

@Mapper
public interface NoticeDao {

	
	public List<Notice> listArticle(Page page) throws SQLException;
	public int getTotalCount(Page page) throws SQLException;
	public Notice getArticle(int no) throws SQLException;
	
	public int writeArticle(Notice notice) throws SQLException;
	public int modifyArticle(Notice notice) throws SQLException;
	public int deleteArticle(int no) throws SQLException;



	public void updateHit(int no) throws SQLException;
}
