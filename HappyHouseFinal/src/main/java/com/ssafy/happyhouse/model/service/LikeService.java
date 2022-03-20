package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Like;

public interface LikeService {
	List<Like> getLikes(String userId) throws SQLException;
	int selectLike(Like like) throws SQLException;
	int unLike(Like like) throws SQLException;
}
