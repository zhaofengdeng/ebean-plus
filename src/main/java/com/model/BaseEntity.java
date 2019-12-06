package com.model;

import java.util.Date;

import com.util.base.StringUtil;

import io.ebean.Ebean;

public abstract class BaseEntity {
	public abstract void setInsertedAt(Date date);
	public abstract void setUpdatedAt(Date updatedAt) ;
	public abstract void setDeleted(Boolean deleted);
	public abstract Object getId();
	public void save() {
		this.setInsertedAt(new Date());
		this.setUpdatedAt(new Date());
		this.setDeleted(false);
		Ebean.save(this);
	}
	public void update() {
		this.setUpdatedAt(new Date());
		Ebean.update(this);
	}
	
	public void saveOrUpdate() {
		if(this.getId()!=null&&StringUtil.isNotNullOrEmpty(this.getId().toString())) {
			this.update();
		}else{
			this.save();
		}
	}
	
}
