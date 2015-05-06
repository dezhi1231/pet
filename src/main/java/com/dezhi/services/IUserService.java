package com.dezhi.services;

import java.util.List;

import com.dezhi.action.UserEntity;

public interface IUserService {
	
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public UserEntity findUserByUserName(String userName);
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean addUser(UserEntity user);
	
	/**
	 * 查询用户List
	 * @param userName
	 * @return
	 */
	public List<UserEntity> findUserList(String userName);
	
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public boolean delUser(int id);
	
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(UserEntity user);
	

}
