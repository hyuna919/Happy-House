package com.ssafy.happyhouse.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class Page {

	@ApiModelProperty(value = "현재 페이지 번호")
	private int pg;
	@ApiModelProperty(value = "페이지당 글갯수")
	private int spp;
	@ApiModelProperty(value = "페이지의 시작 글번호")
	private int start;
	@ApiModelProperty(value = "검색 조건")
	private String key;
	@ApiModelProperty(value = "검색어")
	private String word;
	public Page() {
		super();
	}
	public Page(int pg, int spp, int start, String key, String word) {
		super();
		this.pg = pg;
		this.spp = spp;
		this.start = start;
		this.key = key;
		this.word = word;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getSpp() {
		return spp;
	}
	public void setSpp(int spp) {
		this.spp = spp;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "Page [pg=" + pg + ", spp=" + spp + ", start=" + start + ", key=" + key + ", word=" + word + "]";
	}
	
	
	
}
