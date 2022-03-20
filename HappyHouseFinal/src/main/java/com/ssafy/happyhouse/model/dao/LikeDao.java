package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Like;


@Mapper
public interface LikeDao {

	List<Like> getLikes(String userId) throws SQLException;
	int selectLike(Like like) throws SQLException;
	int unLike(Like like) throws SQLException;
}
