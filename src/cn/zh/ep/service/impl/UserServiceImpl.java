
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

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��2�� ����1:24:54 

* ˵�� ��

*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void register(User user) {
		//������Ч��У��
		//���������MD5����
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		userMapper.insert(user);
	}

	/**
	 * �û�������У��
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
		
//		 1.�ж��û����������Ƿ���ȷ
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		//ִ�в�ѯ
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		//ȡ�û���Ϣ
		User user = list.get(0);
		//�ж������Ƿ���ȷ
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			//2.�������ȷ�����ص�¼ʧ��
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
