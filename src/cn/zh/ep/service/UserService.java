
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.User;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月2日 下午1:22:56 

* 说明 ：登录注册Service

*/

public interface UserService {
	void register(User user);
	boolean checkUsername(String username);
	//参数：用户名和密码
	//业务逻辑
	/**
	 * 1.判断用户名和密码是否正确
	 * 2.如果不正确，返回登录失败
	 * 3.如果正确，登录系统
	 * @return 
	 */
	User userLogin(String username,String password);
	/**
	 * 查询用户数
	 * @return
	 */
	Integer count();
	/**
	 * 增加管理员
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 查询全部的管理员
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<User> selectUserList(Integer page, Integer limit);
	/**
	 * 通过id查询管理员信息
	 * @param userId
	 * @return
	 */
	User selectUserById(String userId);
	/**
	 * 修改管理员信息
	 * @param user
	 */
	void editUser(User user);
	/**
	 * 通过id修改管理员密码
	 * @param id
	 * @param password
	 */
	void updateUserPassword(String id, String password);
	/**
	 * 通过id删除管理员
	 * @param id
	 */
	void delUserById(String id);
	/**
	 * 通过账号或者真实姓名模糊查询
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<User> searchUser(Integer page, Integer limit, String keyword);
}
