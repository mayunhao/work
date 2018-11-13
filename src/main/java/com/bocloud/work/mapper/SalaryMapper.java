package com.bocloud.work.mapper;

import java.util.List;

import com.bocloud.work.SuperMapper;
import com.bocloud.work.entity.Salary;

public interface SalaryMapper extends SuperMapper<Salary>{

	void save(Salary salary);    
    boolean update(Salary salary);    
    boolean delete(int id);    
    Salary findById(int id);    
    List<Salary> findAllList();
	 
	

}
