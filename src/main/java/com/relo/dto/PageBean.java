package com.relo.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class PageBean<T> {
	public final static int CNT_PER_PAGE = 5;
	public final static int CNT_PER_PAGE_GROUP = 5;
	private List<T> list;
	private int totalCnt;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int currentPage;

	public PageBean(int currentPage, List<T> list, int totalCnt) {
		this.currentPage = currentPage;
		this.list = list;
		this.totalCnt = totalCnt;
		this.totalPage = (int) Math.ceil((double) totalCnt / CNT_PER_PAGE);
		this.startPage = (currentPage - 1) / CNT_PER_PAGE_GROUP * CNT_PER_PAGE_GROUP + 1;
		this.endPage = startPage + CNT_PER_PAGE_GROUP - 1;
	}
	
}
