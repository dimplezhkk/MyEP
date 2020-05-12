
package cn.zh.ep.service;

import java.util.List;

import cn.zh.ep.pojo.Music;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午11:07:07 

* 说明 ：

*/

public interface HomeMusicService {

	/**
	 * 通过歌单id查询歌单音乐
	 * @param id
	 * @return
	 */
	List<Music> selectMusicListBySongSheetId(Integer id);

}
