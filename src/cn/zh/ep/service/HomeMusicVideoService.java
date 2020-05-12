
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Musicvideo;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月16日 下午3:34:44 

* 说明 ：

*/

public interface HomeMusicVideoService {

	/**
	 * 查询最新的三条MV数据
	 * @return
	 */
	PageInfo<Musicvideo> selectThreeNewMusicVideo(Integer page, Integer limit);
	
	/**
	 * 查询全部MV进行分页
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Musicvideo> selectMusicVideoList(Integer page, Integer limit);

	/**
	 * 通过歌手姓名查询歌手MV
	 * @param singer
	 * @return
	 */
	List<Musicvideo> selectMusicVideoBySingerName(String singer);

	

}
