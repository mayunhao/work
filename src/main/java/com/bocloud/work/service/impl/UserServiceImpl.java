package com.bocloud.work.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bocloud.work.entity.User;
import com.bocloud.work.mapper.UserMapper;
import com.bocloud.work.service.IUserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService{
	
	@Resource
	private UserMapper mapper;
	
	 public boolean delete(int id) {  
	        return mapper.delete(id);  
	    }  
	    /**  
	     * 查询User的全部数据  
	     */  
	  public List<User> findAllList() {  
	        return mapper.findAllList();  
	    }
	    /**  
	     * 根据 id 查询 对应数据  
	     */  
	    public User findById(int id) {  
	        User user = mapper.findById(id);  
	        return user;  
	    }  
	    /**  
	     * 新增数据  
	     */  
	    public void save(User user) {  
	        mapper.save(user);  
	    }  
	    /**  
	     * 根据 id 修改对应数据  
	     */  
	    public boolean update(User user) {  
	        return mapper.update(user);  
	    }
	    /* 登陆验证 */
	    public User checkLogin(String name, String pwd) {
	        //根据用户名实例化用户对象
	        User user = mapper.getUserByName(name);
	        if (user != null && user.getPwd().equals(pwd)) {
	            return user;
	        }
	        return null;
	    }
		@Override
		public User checkLogin(String name, Long pwd) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
