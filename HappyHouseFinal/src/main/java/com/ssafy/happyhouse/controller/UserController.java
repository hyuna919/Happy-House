package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.JwtService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
@Api("User Controller")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtService jwtService;
	
	String SUCCESS = "SUCCESS";
	String FAIL = "FAIL";
	
	@ApiOperation(value="전체 회원 정보", notes="조회")
	@GetMapping
	public ResponseEntity<List<User>> selectAll(Page page) throws Exception{
		logger.debug("USER select All......................");
		List<User> list = userService.selectAll(page);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="ID CHECK", notes="조회")
	@GetMapping("idCheck/{userId}")
	public ResponseEntity<String> idCheck(@PathVariable("userId") String id,HttpServletRequest request) throws Exception {
		logger.debug("USER ID check......................"+id);
		User user = userService.selectOne(id);
		System.out.println(user);
		if(user==null) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}else {			
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);

		}
	}
	
	@ApiOperation(value="회원 정보조회", notes="조회")
	@GetMapping("/{userId}")
	public ResponseEntity<Map<String, Object>> selectOne(@PathVariable("userId") String id,
			HttpServletRequest request) {
		logger.debug("USER select One......................"+id);
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				User user = userService.selectOne(id);
				resultMap.put("userInfo", user);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value="회원 등록", notes="등록")
	@PostMapping
	public ResponseEntity<String> regist(@RequestBody User user) throws Exception{
		logger.debug("USER regist......................");
		if(userService.regist(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="회원 수정", notes="수정")
	@PutMapping
	public ResponseEntity<String> update(@RequestBody User user) throws Exception{
		logger.debug("USER update......................");
		if(userService.update(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="회원 삭제", notes="삭제")
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> remove(@PathVariable("userId") String id) throws Exception{
		logger.debug("USER remove.......................");
		if(userService.remove(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	// 로그인
	// 로그아웃은 프론트에서 처리함
//	@PostMapping("/login")
	@GetMapping("/login/{userId}/{userPw}")
	public ResponseEntity<Map<String, Object>> login(@PathVariable String userId, @PathVariable String userPw) throws Exception{
		logger.debug("USER login......................");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		User user = new User(userId, userPw);
		try {
			User loginUser = userService.login(user);
			if (loginUser != null) {	// 로그인 되면 => DB에서 가져오는데 문제없으면
				String token = jwtService.create("userId", loginUser.getUserId(), "access-token");// key, data, subject
				logger.debug("login token info : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {					// 로그인 안되면 => 없는 회원일 가능성 높음
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("login fail : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}	
	
	
	// 비밀번호 찾기 시 이메일 전송
	@PostMapping("/password/{userId}")
	public ResponseEntity<String> execPasswordMail(@PathVariable String userId) throws Exception {
		logger.debug("USER execPasswordMail......................"+userId);		

		if(userService.sendMail(userId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

}
