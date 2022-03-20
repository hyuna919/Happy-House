package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.User;
@Mapper
public interface UserDao {
	// 회원 전체조회-한명조회-등록-수정-삭제
	public List<User> selectAll(Page page) throws SQLException;
	public User selectOne(String id) throws SQLException;
	public int regist(User user) throws SQLException;
	public int update(User user) throws SQLException;
	public int remove(String id) throws SQLException;
	
	// 로그인
	public User login(User user) throws SQLException;
	
	// 비밀번호 찾기
	public User searchPassword(String id) throws SQLException;
	
}
