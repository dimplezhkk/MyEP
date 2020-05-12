
package cn.zh.ep.service;


import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Songsheet;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月11日 下午10:15:36 

* 说明 ：

*/

public interface SongSheetService {

	/**
	 * 增加歌单
	 * @param songsheet
	 */
	void addSongSheet(Songsheet songsheet);

	/**
	 * 查询歌单数据展示
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Songsheet> showSongSheetList(Integer page, Integer limit);

	/**
	 * 通过id查询歌单信息
	 * @param songSheetId
	 * @return
	 */
	Songsheet selectSongSheetById(String songSheetId);

	/**
	 * 通过id修改歌单
	 * @param songSheet
	 */
	void editSongSheetById(Songsheet songSheet);

	/**
	 * 通过id删除歌单信息
	 * @param songSheetId
	 */
	void delSongSheetById(String songSheetId);

	/**
	 * 通过创建人查询搜索歌单
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Songsheet> searchResult(Integer page, Integer limit, String keyword);

	/**
	 * 查询歌单数
	 * @return
	 */
	Integer count();

	

}
