package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.User;

public interface UserService {
	// 회원 전체조회-한명조회-등록-수정-삭제
		public List<User> selectAll(Page page) throws Exception;
		public User selectOne(String id) throws Exception;
		public boolean regist(User user) throws Exception;
		public boolean update(User user) throws Exception;
		public boolean remove(String id) throws Exception;
		
		// 로그인, 로그아웃
		public User login(User user) throws Exception;
		
		// 비밀번호 찾기 메일
		public boolean sendMail(String email) throws Exception;
}
