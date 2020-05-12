
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.SingerWithBLOBs;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午2:32:43 

* 说明 ：

*/

public interface HomeSingerService {

	/**
	 * 查询华语歌手
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showhySingerListByPage(Integer page, Integer limit);

	/**
	 * 查询华语组合
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showhyComposeListByPage(Integer page, Integer limit);

	/**
	 * 查询日韩歌手
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showrhSingerListByPage(Integer page, Integer limit);

	/**
	 * 查询日韩组合
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showrhComposeListByPage(Integer page, Integer limit);

	/**
	 * 查询欧美歌手
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showomSingerListByPage(Integer page, Integer limit);

	/**
	 * 查询欧美组合
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SingerWithBLOBs> showomComposeListByPage(Integer page, Integer limit);

	/**
	 * 通过歌手名模糊查询歌手
	 * @param keyword
	 * @return
	 */
	List<SingerWithBLOBs> searchSinger(String keyword);

}
