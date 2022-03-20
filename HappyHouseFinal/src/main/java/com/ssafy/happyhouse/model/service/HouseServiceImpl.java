package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dto.House;
import com.ssafy.happyhouse.model.dto.SidoGugunDongCode;

@Service
public class HouseServiceImpl implements HouseService {

	
	@Autowired
	HouseDao dao;
	
	
	@Override
	public List<SidoGugunDongCode> getSido() throws SQLException {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunDongCode> getGugunInSido(String sido) throws SQLException {
		return dao.getGugunInSido(sido);
	}

	@Override
	public List<House> getDongInGugun(String gugun) throws SQLException {
		return dao.getDongInGugun(gugun);
	}

	@Override
	public List<House> getAptInDong(String dong , String gugun, String userId) throws SQLException {
		return dao.getAptInDong(dong, gugun, userId);
	}

	@Override
	public List<House> getAptInLike(String userId) throws SQLException {
		return dao.getAptInLike(userId);
	}

}
