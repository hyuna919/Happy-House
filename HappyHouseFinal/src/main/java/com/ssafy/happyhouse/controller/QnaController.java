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

import com.ssafy.happyhouse.model.dto.Page;
import com.ssafy.happyhouse.model.dto.Qna;
import com.ssafy.happyhouse.model.service.QnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
@Api("QnA Controller")
public class QnaController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	String SUCCESS = "SUCCESS";
	String FAIL = "FAIL";
	
	@Autowired
	private QnaService qnaService;
	
	@ApiOperation(value = "게시판 글작성")
	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody Qna qna) throws Exception {
		logger.info("writeArticle - 호출");
		if (qnaService.writeArticle(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시판 글목록", response = List.class)
	@GetMapping
	public ResponseEntity<List<Qna>> listArticle(Page page) throws Exception {
		logger.info("listArticle - 호출 : +" + page.toString());
		return new ResponseEntity<List<Qna>>(qnaService.listArticle(page), HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글보기", response = Qna.class)
	@GetMapping("/{articleno}")
	public ResponseEntity<Qna> getArticle(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("getArticle - 호출 : " + articleno);
		qnaService.updateHit(articleno);
		return new ResponseEntity<Qna>(qnaService.getArticle(articleno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글수정", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody Qna qna) throws Exception {
		logger.info("modifyArticle - 호출");
		
		if (qnaService.modifyArticle(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글삭제", response = String.class)
	@DeleteMapping("/{articleno}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("deleteArticle - 호출");
		if (qnaService.deleteArticle(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "답변 작성")
	@PostMapping("/answer")
	public ResponseEntity<String> writeAnswer(@RequestBody Qna qna) throws Exception {
		logger.info("writeAnswer - 호출");
		if (qnaService.writeAnswer(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "답변 글수정", response = String.class)
	@PutMapping("/answer")
	public ResponseEntity<String> modifyAnswer(@RequestBody Qna qna) throws Exception {
		logger.info("modifyAnswer - 호출");
		
		if (qnaService.modifyAnswer(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "답변 글삭제", response = String.class)
	@DeleteMapping("/answer/{articleno}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("articleno") int articleno) throws Exception {
		logger.info("deleteAnswer - 호출");
		if (qnaService.deleteAnswer(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
