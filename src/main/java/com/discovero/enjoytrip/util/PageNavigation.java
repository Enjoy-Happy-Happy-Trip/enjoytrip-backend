package com.discovero.enjoytrip.util;

public class PageNavigation {
	public static final int NAVI_SIZE = 5;
	public static final int COUNT_PER_PAGE = 10;
	
	private int currentPage; // 현재 페이지 번호
	private int totalCount; // 총 게시글 갯수
	// private int newCount; // 새글 갯수
	private int naviSize; // 네비게이션 사이즈 -> 5
	private int countPerPage; // 페이지당 글 갯수 -> 10
	
	public PageNavigation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageNavigation(int currentPage, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.naviSize = NAVI_SIZE;
		this.countPerPage = COUNT_PER_PAGE;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
}
