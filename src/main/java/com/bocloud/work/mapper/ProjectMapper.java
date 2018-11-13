package com.bocloud.work.mapper;

import java.util.List;

import com.bocloud.work.SuperMapper;
import com.bocloud.work.entity.Project;

public interface ProjectMapper extends SuperMapper<Project>{

	void save(Project project);    
    boolean update(Project project);    
    boolean delete(int id);    
    Project findById(int id);    
    List<Project> findAllList();
	
	 
	
}