
package cn.zh.ep.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Album;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月10日 下午10:48:01 

* 说明 ：

*/

public interface AlbumService {

	/**
	 * 保存专辑信息
	 * @param album
	 */
	void addAlbum(Album album);

	/**
	 * 分页展示专辑信息
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Album> showAlbumListByPage(Integer page, Integer limit);

	/**
	 * 根据专辑id查找专辑信息
	 * @param albumId
	 * @return
	 */
	Album editAlbum(String albumId);
	/**
	 * 通过id查找专辑并修改专辑信息
	 * @param album
	 */
	void editAlbumById(Album album);

	/**
	 * 通过id删除专辑信息
	 * @param albumId
	 */
	void delAlbum(String albumId);

	/**
	 * 根据关键字模糊查找专辑信息，关键字为歌手名或者专辑名称
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Album> searchResult(Integer page, Integer limit, String keyword);

	ArrayList selectAlbumListToSelect();

	/**
	 * 通过歌手姓名查询歌手专辑
	 * @param singer
	 * @return
	 */
	List<Album> showAlbumListBySingerName(String singer);

	/**
	 * 查询专辑数
	 * @return
	 */
	Integer count();

}
