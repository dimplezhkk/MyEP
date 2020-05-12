
package cn.zh.ep.service.impl;



import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.UserMapper;
import cn.zh.ep.pojo.User;
import cn.zh.ep.pojo.UserExample;
import cn.zh.ep.pojo.UserExample.Criteria;
import cn.zh.ep.service.UserService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月2日 下午1:24:54 

* 说明 ：

*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void register(User user) {
		//数据有效性校验
		//对密码进行MD5加密
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		userMapper.insert(user);
	}

	/**
	 * 用户名数据校验
	 */
	@Override
	public boolean checkUsername(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User userLogin(String username, String password) {
		
//		 1.判断用户名和密码是否正确
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		//执行查询
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		//取用户信息
		User user = list.get(0);
		//判断密码是否正确
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			//2.如果不正确，返回登录失败
			return null;
		}
		return user; 
	}

	@Override
	public Integer count() {
		UserExample example = new UserExample();
		Integer user = userMapper.countByExample(example);
		return user;
	}

	@Override
	public void insertUser(User user) {
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		userMapper.insert(user);
	}

	@Override
	public PageInfo<User> selectUserList(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public User selectUserById(String userId) {
		Integer parseInt = Integer.parseInt(userId);
		User user = userMapper.selectByPrimaryKey(parseInt);
		return user;
	}

	@Override
	public void editUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void updateUserPassword(String Id, String Password) {
		Integer id = Integer.parseInt(Id);
		String password = DigestUtils.md5DigestAsHex(Password.getBytes());
		userMapper.editUserPassword(password,id);
	}

	@Override
	public void delUserById(String id) {
		Integer parseInt = Integer.parseInt(id);
		userMapper.deleteByPrimaryKey(parseInt);
	}

	@Override
	public PageInfo<User> searchUser(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page, limit);
		List<User> list = userMapper.searchUserList(keyword);
		PageInfo<User> info = new PageInfo<>(list);
		return info;
	}
}
