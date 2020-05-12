
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Consumer;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月20日 下午1:55:35 

* 说明 ：

*/

public interface HomeConsumerService {

	/**
	 * 检查用户账号是否存在
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);

	/**
	 * 检查邮箱是否存在
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);

	/**
	 * 用户注册
	 * @param consumer
	 */
	void register(Consumer consumer);

	/**
	 * 通过用户账号和密码登录
	 * @param username
	 * @param password
	 * @return
	 */
	Consumer consumerLogin(String username, String password);

	/**
	 * 通过账号查询客户信息
	 * @param username
	 * @return
	 */
	Consumer selectConsumerByUsername(String username);

	/**
	 * 修改用户设置
	 * @param consumer
	 */
	void setConsumer(Consumer consumer);

	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	void updatePassword(String id, String password);

	/**
	 * 查询用户列表
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Consumer> selectConsumerList(Integer page, Integer limit);

	/**
	 * 通过id查询用户信息
	 * @param consumerId
	 * @return
	 */
	Consumer selectConsumerById(String consumerId);

	/**
	 * 通过id修改用户信息
	 * @param consumer
	 */
	void updateConsumer(Consumer consumer);

	/**
	 * 通过id删除用户信息
	 * @param consumerId
	 */
	void delConsumerById(String consumerId);

	/**
	 * 通过用户账号查询用户
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Consumer> selectConsumerListByUsername(Integer page, Integer limit, String keyword);

	/**
	 * 查询前台注册用户数
	 * @return
	 */
	Integer count();

}
