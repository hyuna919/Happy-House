package com.ssafy.happyhouse.model.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ssafy.happyhouse.Exception.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

	public static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

	private static final String SALT = "securitySalt";
	private static final int EXPIRE_MINUTES = 30;
	private static final int EXPIRE_SECONDS = 1000*60*EXPIRE_MINUTES;
	
	@Override
	public <T> String create(String key, T data, String subject) {
		// jjwt : JWT토큰 생성+파싱+검증
		String jwt = Jwts.builder()
				.setHeaderParam("typ","JWT")		// header : 
				.setHeaderParam("regDate", System.currentTimeMillis())
//				.setHeaderParam("alg", "HS256")
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRE_SECONDS))	// 만료
				.setSubject(subject)				// 토큰 용도
				.claim(key, data)					// claim : payload에 담는 정보를 claim이라 한다
				.signWith(SignatureAlgorithm.HS256, this.generateKey())	// 서명
				.compact();							// 토큰 생성
		
		return jwt;
	}

	// 이 함수 없이 하려면 exception 달아줘야하는데 그것보단 이렇게 따로하는게 키 생성 방법 바꿀때 좋은듯 => 키 생성법에 따라 예외처리 다르게해야 함
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = SALT.getBytes("UTF-8");	// 디코딩 작업
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				e.printStackTrace();
			} else {
				logger.error("Making JWT Key Error ::: {}", e.getMessage());
			}
		}

		return key;
	}

	@Override
	// request에서 토큰 받아와서 파싱
	public Map<String, Object> get(String key) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String jwt = request.getHeader("access-token");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new UnauthorizedException();
		}
		Map<String, Object> value = claims.getBody();
		logger.info("value : {}", value);
		return value;
		
	}

	@Override
	public String getUserId() {
		return (String)this.get("user").get("userId");
	}

	@Override
	// 토큰 파싱 가능한지 확인
	public boolean isUsable(String jwt) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

}
