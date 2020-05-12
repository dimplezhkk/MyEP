
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Musicvideo;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月12日 下午10:22:02 

* 说明 ：

*/

public interface MusicVideoService {

	/**
	 * 增加mv信息
	 * @param mv
	 */
	void addMusicVideo(Musicvideo mv);

	/**
	 * 分页查询MV显示到页面
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Musicvideo> selectMusicVideoList(Integer page, Integer limit);

	/**
	 * 通过MV的id查询MV的信息展示到修改页面上
	 * @param mvId
	 * @return
	 */
	Musicvideo selectMusicVideoById(String mvId);
	
	/**
	 * 通过id修改MV的信息
	 * @param mv
	 */
	void selectMusicVideoById(Musicvideo mv);

	/**
	 * 通过id删除MV信息
	 * @param mvId
	 */
	void delMusicVideoById(String mvId);

	/**
	 * 通过关键字（MV名称或者MV歌手名）查询MV
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Musicvideo> searchResult(Integer page, Integer limit, String keyword);

	/**
	 * 查询MV数
	 * @return
	 */
	Integer count();

}
