package com.bocloud.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bocloud.work.entity.Department;
import com.bocloud.work.entity.User;
import com.bocloud.work.mapper.DepartmentMapper;
import com.bocloud.work.mapper.UserMapper;
import com.bocloud.work.service.IDepartmentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DZG
 * @since 2017-07-11
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
	
	@Resource
	private DepartmentMapper mapper;
	
	 public boolean delete(int id) {  
	        return mapper.delete(id);  
	    }  
	    /**  
	     * 查询User的全部数据  
	     */  
	  public List<Department> findAllList() {  
	        return mapper.findAllList();  
	    }
	    /**  
	     * 根据 id 查询 对应数据  
	     */  
	    public Department findById(int id) {  
	    	Department department = mapper.findById(id);  
	        return department;  
	    }  
	    /**  
	     * 新增数据  
	     */  
	    public void save(Department department) {  
	        mapper.save(department);  
	    }  
	    /**  
	     * 根据 id 修改对应数据  
	     */  
	    public boolean update(Department department) {  
	        return mapper.update(department);  
	    }
	
	
}
