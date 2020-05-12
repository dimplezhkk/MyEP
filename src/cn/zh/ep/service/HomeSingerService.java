
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.SingerWithBLOBs;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��15�� ����2:32:43 

* ˵�� ��

*/

public interface HomeSingerService {

	/**
	 * ��ѯ�������
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showhySingerListByPage(Integer page, Integer limit);

	/**
	 * ��ѯ�������
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showhyComposeListByPage(Integer page, Integer limit);

	/**
	 * ��ѯ�պ�����
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showrhSingerListByPage(Integer page, Integer limit);

	/**
	 * ��ѯ�պ����
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showrhComposeListByPage(Integer page, Integer limit);

	/**
	 * ��ѯŷ������
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showomSingerListByPage(Integer page, Integer limit);

	/**
	 * ��ѯŷ�����
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showomComposeListByPage(Integer page, Integer limit);

	/**
	 * ͨ��������ģ����ѯ����
	 * @param keyword
	 * @return
	 */
	List<SingerWithBLOBs> searchSinger(String keyword);

}
