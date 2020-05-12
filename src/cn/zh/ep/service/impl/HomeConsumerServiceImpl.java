
package cn.zh.ep.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.ConsumerMapper;
import cn.zh.ep.pojo.Consumer;
import cn.zh.ep.pojo.ConsumerExample;
import cn.zh.ep.pojo.User;
import cn.zh.ep.pojo.UserExample;
import cn.zh.ep.pojo.ConsumerExample.Criteria;
import cn.zh.ep.service.HomeConsumerService;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��20�� ����1:56:47 

* ˵�� ��

*/
@Service
public class HomeConsumerServiceImpl implements HomeConsumerService{

	@Autowired
	private ConsumerMapper consumerMapper;
	
	@Override
	public boolean checkUsername(String username) {
		ConsumerExample example = new ConsumerExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Consumer> list = consumerMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		ConsumerExample example = new ConsumerExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<Consumer> list = consumerMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void register(Consumer consumer) {
		//������Ч��У��
		if (StringUtils.isBlank(consumer.getPassword()) || StringUtils.isBlank(consumer.getEmail())
			|| StringUtils.isBlank(consumer.getUsername())) {
			return;
		}
		//���������MD5����
		String md5Pass = DigestUtils.md5DigestAsHex(consumer.getPassword().getBytes());
		consumer.setPassword(md5Pass);
		consumerMapper.insert(consumer);
	}

	@Override
	public Consumer consumerLogin(String username, String password) {
		
		 //�ж��û����������Ƿ���ȷ
			ConsumerExample example = new ConsumerExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			//ִ�в�ѯ
			List<Consumer> list = consumerMapper.selectByExample(example);
			if (list == null || list.size() == 0) {
				return null;
			}
			//ȡ�û���Ϣ
			Consumer consumer = list.get(0);
			//�ж������Ƿ���ȷ
			if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(consumer.getPassword())) {
				//2.�������ȷ�����ص�¼ʧ��
				return null;
			}
			return consumer;
	}

	@Override
	public Consumer selectConsumerByUsername(String username) {
		ConsumerExample example = new ConsumerExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Consumer> list = consumerMapper.selectByExample(example);
		Consumer consumer = list.get(0);
		return consumer;
	}

	@Override
	public void setConsumer(Consumer consumer) {
		consumerMapper.updateByPrimaryKey(consumer);
	}

	@Override
	public void updatePassword(String Id, String Password) {
		Integer id = Integer.parseInt(Id);
		String password = DigestUtils.md5DigestAsHex(Password.getBytes());
		consumerMapper.updatePassword(password,id);
	}

	@Override
	public PageInfo<Consumer> selectConsumerList(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		ConsumerExample example = new ConsumerExample();
		List<Consumer> list = consumerMapper.selectByExample(example);
		PageInfo<Consumer> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public Consumer selectConsumerById(String consumerId) {
		Integer parseInt = Integer.parseInt(consumerId);
		Consumer consumer = consumerMapper.selectByPrimaryKey(parseInt);
		return consumer;
	}

	@Override
	public void updateConsumer(Consumer consumer) {
		consumerMapper.updateByPrimaryKey(consumer);
	}

	@Override
	public void delConsumerById(String consumerId) {
		Integer parseInt = Integer.parseInt(consumerId);
		consumerMapper.deleteByPrimaryKey(parseInt);
	}

	@Override
	public PageInfo<Consumer> selectConsumerListByUsername(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page, limit);
		ConsumerExample example = new ConsumerExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%" + keyword + "%");
		List<Consumer> list = consumerMapper.selectByExample(example);
		PageInfo<Consumer> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public Integer count() {
		ConsumerExample example = new ConsumerExample();
		Integer consumer = consumerMapper.countByExample(example);
		return consumer;
	}
}
