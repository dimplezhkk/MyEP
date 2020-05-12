
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Rotation;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��17�� ����11:43:35 

* ˵�� ��

*/

public interface RotationService {

	/**
	 * �����ֲ�ͼ
	 * @param rotation
	 */
	void addRotation(Rotation rotation);

	/**
	 * ��ҳ��ѯ�ֲ�ͼƬ
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Rotation> selectRotationList(Integer page, Integer limit);

	/**
	 * ͨ��id��ѯid
	 * @param rotationId
	 * @return
	 */
	Rotation selectRotationById(String rotationId);

	/**
	 * ͨ��id�޸��ֲ�ͼ
	 * @param rotation
	 */
	void editRotation(Rotation rotation);

	/**
	 * ͨ��idɾ���ֲ�ͼ
	 * @param rotationId
	 */
	void delRotationById(String rotationId);

	/**
	 * ��ѯ�ֲ�ͼƬ
	 * @return
	 */
	List<Rotation> selectRotationList();

}
