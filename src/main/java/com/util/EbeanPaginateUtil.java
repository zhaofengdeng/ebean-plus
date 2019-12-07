package com.util;

import java.util.List;


import com.model.Paginate;
import com.util.base.IntUtil;
import com.util.base.StringUtil;

import io.ebean.ExpressionList;
import io.ebean.Query;
/**
 * 分页工具类
 * @author 赵丰登
 *
 */
public class EbeanPaginateUtil {
	/**
	 * 
	 * @param el
	 * @param curPage    当前页数
	 * @param maxPerPage 每页最大条数（每页多少条）
	 * @return
	 */
	public  static  <T>  Paginate paginate(ExpressionList<T> el, int curPage, int maxPerPage) {
		if (el == null) {
			throw new NullPointerException();
		}
		Query query = el.query();
		return paginate(query, curPage, maxPerPage);
	}
	/**
	 * 
	 * @param el
	 * @param curPage    当前页数,为空第一页
	 * @param maxPerPage 每页最大条数（每页多少条）,为空15条
	 * @return
	 */
	public  static  <T>  Paginate paginate(ExpressionList<T> el, String curPage, String maxPerPage) {
		Integer curPageInt=IntUtil.parseInt(curPage);
		Integer maxPerPageInt=IntUtil.parseInt(maxPerPage);
		if(curPageInt==null) {
			curPageInt=1;
		}
		if(maxPerPageInt==null) {
			maxPerPageInt=15;
		}
		return paginate(el, curPageInt, maxPerPageInt);
	}
	public  static  <T>  Paginate paginate(Query<T> query, String curPage, String maxPerPage) {
		Integer curPageInt=IntUtil.parseInt(curPage);
		Integer maxPerPageInt=IntUtil.parseInt(maxPerPage);
		if(curPageInt==null) {
			curPageInt=1;
		}
		if(maxPerPage==null) {
			maxPerPageInt=15;
		}
		return paginate(query, curPageInt, maxPerPageInt);
	}

	/**
	 * 
	 * @param query
	 * @param curPage    当前页数
	 * @param maxPerPage 每页最大条数（每页多少条）
	 * @return
	 */
	public static  <T> Paginate paginate(Query<T> query, int curPage, int maxPerPage) {
		if (query == null) {
			throw new NullPointerException();
		}
		Paginate<T> paginate=new Paginate<T>();
		paginate.setCurPage(curPage);
		paginate.setMaxPerPage(maxPerPage);
		int dataCount = query.findCount();
		paginate.setDataCount(dataCount);
		query.setFirstRow((curPage - 1) * maxPerPage);
		query.setMaxRows(maxPerPage);
 		paginate.setModels(query.findList());
		int pageQty = calcPage(dataCount, maxPerPage);
		paginate.setPageQty(pageQty);
		return paginate;
	}
	/**
	 * 计算总共多少页
	 * @param dataCount 总条数
	 * @param maxPerPage 每页多少条
	 * @return
	 */
	public static int calcPage(Integer dataCount,Integer maxPerPage) {
		if(dataCount==null) {
			throw new NullPointerException();
		}
		if(maxPerPage==null) {
			throw new NullPointerException();
		}
		int pageQty=dataCount/maxPerPage;
		if(dataCount%maxPerPage>0) {
			pageQty++;
		}
		return pageQty;
		
	}
}
