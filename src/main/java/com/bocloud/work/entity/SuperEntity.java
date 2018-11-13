package com.bocloud.work.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 
 * 顶级实体类
 * 
 * @author DZG
 * @since V1.0 2017年7月11日
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class SuperEntity<T extends Model> extends Model<T> {

	/**
	 * 主键Id
	 */
	@TableId("id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
