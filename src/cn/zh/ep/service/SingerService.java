
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.SingerWithBLOBs;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��9�� ����11:41:03 

* ˵�� ��

*/

public interface SingerService {
	/**
	 * ��Ӹ�����Ϣ
	 */
	void addSinger(SingerWithBLOBs singer);

	/**
	 * ��ʾ������Ϣ�б�
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showSingerListByPage(Integer page, Integer limit);

	/**
	 * ͨ��id���Ҹ�����Ϣ
	 * @param singerId
	 * @return
	 */
	SingerWithBLOBs selectSingerById(String singerId);

	/**
	 * ͨ������id�޸ĸ�����Ϣ
	 * @param singer
	 */
	void editSinger(SingerWithBLOBs singer);

	/**
	 * ͨ������idɾ��������Ϣ
	 * @param singerId
	 */
	void delSingerById(String singerId);

	/**
	 * ͨ��������Ϣ���Ҹ�����Ϣ
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<SingerWithBLOBs> searchSinger(Integer page, Integer limit, String keyword);

	/**
	 * ͨ������������ѯ������Ϣ
	 * @param musicSinger
	 * @return
	 */
	SingerWithBLOBs selectSingerBySingerName(String musicSinger)throws Exception;

	/**
	 * ��ѯ������
	 * @return
	 */
	Integer count();

}
