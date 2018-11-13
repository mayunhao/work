package com.bocloud.work.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.bocloud.work.entity.Salary;

public interface ISalaryService extends IService<Salary>{


	void save(Salary salary);
	boolean update(Salary salary);
	boolean delete(int id);
	Salary findById(int id);	
	List<Salary> findAllList();
	 
}
