package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dao.UserDao;
import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	@Autowired
	public JavaMailSender javaMailSender;

	@Override
	@Transactional
	public List<User> selectAll(Page page) throws Exception {
		int start = page.getPg() == 0 ? 0 : (page.getPg() - 1) * page.getSpp();
		page.setStart(start);
		return dao.selectAll(page);
	}

	@Override
	@Transactional
	public User selectOne(String id) throws Exception {
		return dao.selectOne(id);
	}

	@Override
	@Transactional
	public boolean regist(User user) throws Exception {
		return dao.regist(user) == 1;
	}

	@Override
	@Transactional
	public boolean update(User user) throws Exception {
		return dao.update(user) == 1;
	}

	@Override
	@Transactional
	public boolean remove(String id) throws Exception {
		return dao.remove(id) == 1;
	}

	@Override
	@Transactional
	public User login(User user) throws Exception {
		return dao.login(user);
	}

//	@Transactional
	@Override
	@Async
	public boolean sendMail(String id) throws Exception {
		// 아이디로 메일, 비밀번호 가져오기
		User user = dao.searchPassword(id);

		// 메일 보내기
		if (user != null) {
			SimpleMailMessage simpleMessage = new SimpleMailMessage();
//			 simpleMessage.setFrom("hyuna919@naver.com"); // NAVER, DAUM, NATE일 경우 넣어줘야 함
			simpleMessage.setTo(user.getUserEmail());
			simpleMessage.setSubject("HappyHouse 비밀번호 찾기 이메일");
			simpleMessage.setText(id + "님의 비밀번호는 " + user.getUserPw() + " 입니다.");
			javaMailSender.send(simpleMessage);
			return true;
		} else {
			return false;
		}
	}

}
