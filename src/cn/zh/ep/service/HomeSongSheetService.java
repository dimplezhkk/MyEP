
package cn.zh.ep.service;

import java.util.List;

import cn.zh.ep.pojo.Songsheet;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午10:59:25 

* 说明 ：

*/

public interface HomeSongSheetService {

	/**
	 * 查询最新的歌单显示
	 * @return
	 */
	Songsheet selectNewOneSongSheet();

	/**
	 * 查询所有歌单列表
	 * @return
	 */
	List<Songsheet> selectSongSheetList();

	/**
	 * 根据id查询歌单显示
	 * @param songSheetId
	 * @return
	 */
	Songsheet selectSongSheetBy(String songSheetId);

}
