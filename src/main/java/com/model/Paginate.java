package com.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.form.AjaxForm;

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

	/**
	 * 转换map
	 * 
	 * @return
	 */
	public Map toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("dataCount", dataCount);
		map.put("pageQty", pageQty);
		map.put("curPage", curPage);
		map.put("maxPerPage", maxPerPage);
		return map;
	}

	public AjaxForm toAjaxForm() {
		AjaxForm ajaxForm = new AjaxForm();
		Map<String, Object> map = new HashMap<>();
		map.put("models", models);
		map.put("paginate", toMap());
		ajaxForm.setSuccess(map);
		return ajaxForm;
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
