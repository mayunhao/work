package com.bocloud.work.service;



import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.bocloud.work.entity.User;
import com.bocloud.work.mapper.UserMapper;

public interface IUserService extends IService<User>{
	
	void save(User user);
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);	
	List<User> findAllList();
	static boolean ajaxValidateusername(String username) {
		return UserMapper.ajaxValidateusername(username);
	} 
	
	 public User checkLogin(String name, Long pwd);
	 
}
