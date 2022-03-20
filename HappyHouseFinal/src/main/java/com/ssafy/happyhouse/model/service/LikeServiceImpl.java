package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.dao.LikeDao;
import com.ssafy.happyhouse.model.dto.Like;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao dao;
	
	@Override
	@Transactional
	public List<Like> getLikes(String userId) throws SQLException {
		
		return dao.getLikes(userId);
	}

	@Override
	@Transactional
	public int selectLike(Like like) throws SQLException {
		
		return dao.selectLike(like);
	}

	@Override
	@Transactional
	public int unLike(Like like) throws SQLException {
		return dao.unLike(like);
	}

}
