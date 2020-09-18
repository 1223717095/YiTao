package com.wyurjds.yitao.Utils;

import java.util.Collections;
import java.util.List;

public class PageBean {

	private int currentPage = 1;
	private int pageSize = 10;
	private int totalcount;
	private List<?> data;

	// 通过上面的参数进行计算
	private int prevPage;
	private int nextPage;
	private int endPage;

	public PageBean() {
		this(1, 1, 0, Collections.emptyList());
	}

	public PageBean(int currentPage, int pageSize, int totalcount, List<?> data) {

		this.currentPage = currentPage;
		this.totalcount = totalcount;
		this.data = data;

		if (totalcount <= pageSize) {
			// 总共 一页
			this.prevPage = 1;
			this.nextPage = 1;
			this.endPage = 1;
			return;
		}

		this.endPage = totalcount % pageSize == 0 ? totalcount / pageSize : totalcount / pageSize + 1;
		this.prevPage = currentPage > 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 < endPage ? currentPage + 1 : endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getEndPage() {
		return endPage;
	}

}
