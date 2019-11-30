package com.model;

import java.util.List;

public class Paginate<T> {
	private List<T> models;
	/**
	 * 总数据条数
	 */
	private Integer dataCount;

	/**
	 * 页面数量
	 */
	private Integer pageQty;
	
	/**
	 * 当前页数
	 */
	private Integer curPage;
	
	/**
	 * 每页显示的条数
	 */
	private Integer maxPerPage;


	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}

	public Integer getPageQty() {
		return pageQty;
	}

	public void setPageQty(Integer pageQty) {
		this.pageQty = pageQty;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getMaxPerPage() {
		return maxPerPage;
	}

	public void setMaxPerPage(Integer maxPerPage) {
		this.maxPerPage = maxPerPage;
	}
	
	
}
