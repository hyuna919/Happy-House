package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.House;
import com.ssafy.happyhouse.model.dto.SidoGugunDongCode;
import com.ssafy.happyhouse.model.service.HouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/house")
@Api("House 컨트롤러  API V1")
public class HouseController {

	private final Logger logger = LoggerFactory.getLogger(HouseController.class);

	@Autowired
	private HouseService service;

	@ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunDongCode>> sido() throws Exception {
		logger.info("sido - 호출");
		return new ResponseEntity<List<SidoGugunDongCode>>(service.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군 정보", notes = "전국의 구군을 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunDongCode>> gugun(
			@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
		logger.info("gugun - 호출");
		return new ResponseEntity<List<SidoGugunDongCode>>(service.getGugunInSido(sido), HttpStatus.OK);
	}

	@ApiOperation(value = "동 정보", notes = "선택한 구군의 동을 반환한다.", response = List.class)
	@GetMapping("/dong")
	public ResponseEntity<List<House>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<House>>(service.getDongInGugun(gugun), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 정보", notes = "선택한 동의 아파트 정보를 반환한다.", response = List.class)
	@GetMapping("/apt")
	public ResponseEntity<List<House>> apt(@RequestParam("userId") String userId,@RequestParam("dong") String dong, @RequestParam("gugun") String gugun)
			throws Exception {
		System.out.println(dong);
		return new ResponseEntity<List<House>>(service.getAptInDong(dong, gugun,userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "찜한 아파트 정보", notes = "찜한 아파트 정보를 반환한다.", response = List.class)
	@GetMapping("/aptLike")
	public ResponseEntity<List<House>> aptLike(@RequestParam("userId") String userId)throws Exception {
		return new ResponseEntity<List<House>>(service.getAptInLike(userId), HttpStatus.OK);
	}

}
