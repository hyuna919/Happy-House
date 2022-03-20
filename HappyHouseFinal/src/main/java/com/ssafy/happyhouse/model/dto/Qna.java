package com.ssafy.happyhouse.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class Qna {
	private String no;
	private String userid;
	private String subject;
	private String content;
	private String hit;
	private String regtime;
	private String answer;
	public Qna() {
		super();
	}
	public Qna(String no, String userid, String subject, String content, String hit, String regtime, String answer) {
		super();
		this.no = no;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.regtime = regtime;
		this.answer = answer;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Qna [no=" + no + ", userid=" + userid + ", subject=" + subject + ", content=" + content + ", hit=" + hit
				+ ", regtime=" + regtime + ", answer=" + answer + "]";
	}
	
	

}
