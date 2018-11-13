package com.bocloud.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bocloud.work.entity.Project;
import com.bocloud.work.mapper.ProjectMapper;
import com.bocloud.work.service.IProjectService;

@Service
public class ProjectServicelmpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService{
	
	@Resource
	private ProjectMapper mapper;
	
	 public boolean delete(int id) {  
	        return mapper.delete(id);  
	    }  
	    /**  
	     * 查询User的全部数据  
	     */  
	  public List<Project> findAllList() {  
	        return mapper.findAllList();  
	    }
	    /**  
	     * 根据 id 查询 对应数据  
	     */  
	    public Project findById(int id) {  
	    	Project project = mapper.findById(id);  
	        return project;  
	    }  
	    /**  
	     * 新增数据  
	     */  
	    public void save(Project project) {  
	        mapper.save(project);  
	    }  
	    /**  
	     * 根据 id 修改对应数据  
	     */  
	    public boolean update(Project project) {  
	        return mapper.update(project);  
	    }
	
	
}

