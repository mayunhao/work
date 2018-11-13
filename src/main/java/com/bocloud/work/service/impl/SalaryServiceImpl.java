package com.bocloud.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bocloud.work.entity.Salary;
import com.bocloud.work.mapper.SalaryMapper;
import com.bocloud.work.service.ISalaryService;

@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService{
	
	@Resource
	private SalaryMapper mapper;
	
	 public boolean delete(int id) {  
	        return mapper.delete(id);  
	    }  
	    /**  
	     * 查询User的全部数据  
	     */  
	  public List<Salary> findAllList() {  
	        return mapper.findAllList();  
	    }
	    /**  
	     * 根据 id 查询 对应数据  
	     */  
	    public Salary findById(int id) {  
	    	Salary salary = mapper.findById(id);  
	        return salary;  
	    }  
	    /**  
	     * 新增数据  
	     */  
	    public void save(Salary salary) {  
	        mapper.save(salary);  
	    }  
	    /**  
	     * 根据 id 修改对应数据  
	     */  
	    public boolean update(Salary salary) {  
	        return mapper.update(salary);  
	    }
	
	
}

