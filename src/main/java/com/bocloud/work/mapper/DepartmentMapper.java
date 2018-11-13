package com.bocloud.work.mapper;

import java.util.List;

import com.bocloud.work.SuperMapper;
import com.bocloud.work.entity.Department;
import com.bocloud.work.entity.User;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author DZG
 * @since 2017-07-11
 */
public interface DepartmentMapper extends SuperMapper<Department> {

	void save(Department department);    
    boolean update(Department department);    
    boolean delete(int id);    
    Department findById(int id);    
    List<Department> findAllList();
	 
	
	
}