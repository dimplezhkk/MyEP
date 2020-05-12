
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Rotation;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月17日 上午11:43:35 

* 说明 ：

*/

public interface RotationService {

	/**
	 * 增加轮播图
	 * @param rotation
	 */
	void addRotation(Rotation rotation);

	/**
	 * 分页查询轮播图片
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Rotation> selectRotationList(Integer page, Integer limit);

	/**
	 * 通过id查询id
	 * @param rotationId
	 * @return
	 */
	Rotation selectRotationById(String rotationId);

	/**
	 * 通过id修改轮播图
	 * @param rotation
	 */
	void editRotation(Rotation rotation);

	/**
	 * 通过id删除轮播图
	 * @param rotationId
	 */
	void delRotationById(String rotationId);

	/**
	 * 查询轮播图片
	 * @return
	 */
	List<Rotation> selectRotationList();

}
