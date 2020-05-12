
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.SingerWithBLOBs;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月9日 下午11:41:03 

* 说明 ：

*/

public interface SingerService {
	/**
	 * 添加歌手信息
	 */
	void addSinger(SingerWithBLOBs singer);

	/**
	 * 显示歌手信息列表
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showSingerListByPage(Integer page, Integer limit);

	/**
	 * 通过id查找歌手信息
	 * @param singerId
	 * @return
	 */
	SingerWithBLOBs selectSingerById(String singerId);

	/**
	 * 通过歌手id修改歌手信息
	 * @param singer
	 */
	void editSinger(SingerWithBLOBs singer);

	/**
	 * 通过歌手id删除歌手信息
	 * @param singerId
	 */
	void delSingerById(String singerId);

	/**
	 * 通过歌手信息查找歌手信息
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<SingerWithBLOBs> searchSinger(Integer page, Integer limit, String keyword);

	/**
	 * 通过歌手姓名查询歌手信息
	 * @param musicSinger
	 * @return
	 */
	SingerWithBLOBs selectSingerBySingerName(String musicSinger)throws Exception;

	/**
	 * 查询歌手数
	 * @return
	 */
	Integer count();

}
