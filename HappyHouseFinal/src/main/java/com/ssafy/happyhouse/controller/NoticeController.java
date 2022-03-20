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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
@Api("QnA Controller")
public class NoticeController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	String SUCCESS = "SUCCESS";
	String FAIL = "FAIL";
	
	@Autowired
	private NoticeService noticeService;
	
	@ApiOperation(value = "공지사항 글작성")
	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody Notice notice) throws Exception {
		logger.info("writeArticle - 호출");
		if (noticeService.writeArticle(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "공지사항 목록", response = List.class)
	@GetMapping
	public ResponseEntity<List<Notice>> listArticle(Page page) throws Exception {
		logger.info("listArticle - 호출 : +" + page.toString());
		return new ResponseEntity<List<Notice>>(noticeService.listArticle(page), HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지사항 글보기", response = Notice.class)
	@GetMapping("/{articleno}")
	public ResponseEntity<Notice> getArticle(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("getArticle - 호출 : " + articleno);
		noticeService.updateHit(articleno);
		return new ResponseEntity<Notice>(noticeService.getArticle(articleno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지사항 글수정", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody Notice notice) throws Exception {
		logger.info("modifyArticle - 호출");
		
		if (noticeService.modifyArticle(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "공지사항 글삭제", response = String.class)
	@DeleteMapping("/{articleno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("deleteArticle - 호출");
		if (noticeService.deleteArticle(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
