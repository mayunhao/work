package com.bocloud.work.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.bocloud.work.entity.Department;
import com.bocloud.work.entity.User;
import com.bocloud.work.mapper.UserMapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DZG
 * @since 2017-07-11
 */
public interface IDepartmentService extends IService<Department> {

	void save(Department department);
	boolean update(Department department);
	boolean delete(int id);
	Department findById(int id);	
	List<Department> findAllList();
	


}
