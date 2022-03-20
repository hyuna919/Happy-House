package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.House;
import com.ssafy.happyhouse.model.dto.SidoGugunDongCode;

public interface HouseService {
	List<SidoGugunDongCode> getSido() throws SQLException;
	List<SidoGugunDongCode> getGugunInSido(String sido) throws SQLException;
	List<House> getDongInGugun(String gugun) throws SQLException;
	List<House> getAptInDong(String dong, String gugun, String userId) throws SQLException;
	List<House> getAptInLike(String userId) throws SQLException;

	
}
