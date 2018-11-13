package com.bocloud.work.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.bocloud.work.entity.Project;

public interface IProjectService extends IService<Project> {

	void save(Project project);
	boolean update(Project project);
	boolean delete(int id);
	Project findById(int id);	
	List<Project> findAllList();
	
}
