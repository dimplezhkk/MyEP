
package cn.zh.ep.service;

import java.util.List;

import cn.zh.ep.pojo.Album;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午7:03:37 

* 说明 ：

*/

public interface HomeAlbumService {

	/**
	 * 查询所有的专辑
	 * @return
	 */
	List<Album> showAlbumList();

	/**
	 * 根据专辑id查询专辑信息
	 * @param albumId
	 * @return
	 */
	Album selectAlbumInfo(String albumId);

	/**
	 * 查询专辑最多显示八条
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Album> showAlbumList(Integer page, Integer limit);

}
