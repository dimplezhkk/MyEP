
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Consumer;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��20�� ����1:55:35 

* ˵�� ��

*/

public interface HomeConsumerService {

	/**
	 * ����û��˺��Ƿ����
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);

	/**
	 * ��������Ƿ����
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);

	/**
	 * �û�ע��
	 * @param consumer
	 */
	void register(Consumer consumer);

	/**
	 * ͨ���û��˺ź������¼
	 * @param username
	 * @param password
	 * @return
	 */
	Consumer consumerLogin(String username, String password);

	/**
	 * ͨ���˺Ų�ѯ�ͻ���Ϣ
	 * @param username
	 * @return
	 */
	Consumer selectConsumerByUsername(String username);

	/**
	 * �޸��û�����
	 * @param consumer
	 */
	void setConsumer(Consumer consumer);

	/**
	 * �޸�����
	 * @param id
	 * @param password
	 */
	void updatePassword(String id, String password);

	/**
	 * ��ѯ�û��б�
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Consumer> selectConsumerList(Integer page, Integer limit);

	/**
	 * ͨ��id��ѯ�û���Ϣ
	 * @param consumerId
	 * @return
	 */
	Consumer selectConsumerById(String consumerId);

	/**
	 * ͨ��id�޸��û���Ϣ
	 * @param consumer
	 */
	void updateConsumer(Consumer consumer);

	/**
	 * ͨ��idɾ���û���Ϣ
	 * @param consumerId
	 */
	void delConsumerById(String consumerId);

	/**
	 * ͨ���û��˺Ų�ѯ�û�
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Consumer> selectConsumerListByUsername(Integer page, Integer limit, String keyword);

	/**
	 * ��ѯǰ̨ע���û���
	 * @return
	 */
	Integer count();

}
