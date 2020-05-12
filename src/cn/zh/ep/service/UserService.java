
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.User;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��2�� ����1:22:56 

* ˵�� ����¼ע��Service

*/

public interface UserService {
	void register(User user);
	boolean checkUsername(String username);
	//�������û���������
	//ҵ���߼�
	/**
	 * 1.�ж��û����������Ƿ���ȷ
	 * 2.�������ȷ�����ص�¼ʧ��
	 * 3.�����ȷ����¼ϵͳ
	 * @return 
	 */
	User userLogin(String username,String password);
	/**
	 * ��ѯ�û���
	 * @return
	 */
	Integer count();
	/**
	 * ���ӹ���Ա
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * ��ѯȫ���Ĺ���Ա
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<User> selectUserList(Integer page, Integer limit);
	/**
	 * ͨ��id��ѯ����Ա��Ϣ
	 * @param userId
	 * @return
	 */
	User selectUserById(String userId);
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param user
	 */
	void editUser(User user);
	/**
	 * ͨ��id�޸Ĺ���Ա����
	 * @param id
	 * @param password
	 */
	void updateUserPassword(String id, String password);
	/**
	 * ͨ��idɾ������Ա
	 * @param id
	 */
	void delUserById(String id);
	/**
	 * ͨ���˺Ż�����ʵ����ģ����ѯ
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<User> searchUser(Integer page, Integer limit, String keyword);
}
