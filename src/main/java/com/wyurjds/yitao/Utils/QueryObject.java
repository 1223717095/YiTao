package com.wyurjds.yitao.Utils;



public class QueryObject {

	private Integer currentPage = 1; // 当前页
	private String keyWord;
	private Long topCategoryId;
	private Long secondCategoryId;
	private Integer pageSize = 10; // 每页显示数量

	public Long getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(Long secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	public Integer getStartIndex() {

		return (currentPage - 1) * pageSize;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Long getTopCategoryId() {
		return topCategoryId;
	}

	public void setTopCategoryId(Long topCategoryId) {
		this.topCategoryId = topCategoryId;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
