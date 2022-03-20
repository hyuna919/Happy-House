package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Like;
import com.ssafy.happyhouse.model.dto.Qna;
import com.ssafy.happyhouse.model.dto.SidoGugunDongCode;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/like")
@CrossOrigin(origins="*",maxAge=6000)
@Api("Like 컨트롤러  API V1")
public class LikeController {
	String SUCCESS = "SUCCESS";
	String FAIL = "FAIL";
	private final Logger logger = LoggerFactory.getLogger(LikeController.class);

	@Autowired
	private LikeService service;

	@ApiOperation(value = "찜목록", notes = "찜 목록", response = List.class)
	@GetMapping
	public ResponseEntity<List<Like>> getLikes(
			@RequestParam("userId") @ApiParam(value = "유저 id.", required = true) String userId) throws Exception {
		logger.info("like - 찜");
		return new ResponseEntity<List<Like>>(service.getLikes(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "찜 취소", notes = "찜 빼기", response = List.class)
	@DeleteMapping
	public ResponseEntity<String> gugun(
			@RequestParam("userId") @ApiParam(value = "유저 정보.", required = true) String userId,
			@RequestParam("houseNo") @ApiParam(value = "찜한 매물 정보.", required = true) String houseNo) throws Exception {
		logger.info("unlike - 찜 취소");
		if (service.unLike(new Like(userId, houseNo)) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "찜하기", notes = "찜 넣기", response = List.class)
	@PostMapping
	public ResponseEntity<String> writeArticle(
			@RequestParam("userId") @ApiParam(value = "유저 정보.", required = true) String userId,
			@RequestParam("houseNo") @ApiParam(value = "찜할 매물 정보.", required = true) String houseNo) throws Exception {
		logger.info("writeArticle - 호출");
		System.out.println(userId);
		if (service.selectLike(new Like(userId, houseNo)) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
