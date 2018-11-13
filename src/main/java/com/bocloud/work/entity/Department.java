package com.bocloud.work.entity;

import java.util.Date;

import com.bocloud.work.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * 部门实体类
 * 
 * @author DZG
 * @since V1.0 2017年7月11日
 */
@SuppressWarnings("serial")
public class Department extends SuperEntity<Department> {

	private String name; // 名称
	private Long fatherId; // 父ID
	private Boolean status; // 状态 1存在 0删除
	private String remark; // 描述
	@JsonSerialize(using = DateSerializer.class)
	private Date gmtCreate; // 创建时间
	@JsonSerialize(using = DateSerializer.class)
	private Date gmtModify; // 修改时间
	private Long createrId; // 创建者ID
	private Long menderId; // 创建者ID

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	public Long getMenderId() {
		return menderId;
	}

	public void setMenderId(Long menderId) {
		this.menderId = menderId;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", fatherId=" + fatherId + ", status=" + status + ", remark=" + remark
				+ ", gmtCreate=" + gmtCreate + ", gmtModify=" + gmtModify + ", createrId=" + createrId + ", menderId="
				+ menderId + "]";
	}

}
