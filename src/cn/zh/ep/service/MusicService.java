
package cn.zh.ep.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Music;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月5日 下午7:20:30 

* 说明 ：

*/

public interface MusicService {
	/**
	 * 保存音乐信息
	 */
	void addMusic(Music music);
	/**
	 * 展示音乐数据
	 * @return
	 */
	List<Music> showMusicList();
	PageInfo<Music> showMusicListByPage(Integer page, Integer limit);
	/**
	 * 删除音乐信息
	 * @param musicId
	 */
	void delMusicById(String musicId);
	
	/**
	 * 通过音乐id查询音乐信息
	 * @param musicId
	 * @return
	 */
	Music selectMusicById(String musicId);
	/**
	 * 一个音乐id修改音乐信息
	 * @param music
	 * @param musicId
	 */
	void editMusic(Music music);
	/**
	 * 条件查询音乐信息并分页
	 * @param limit 
	 * @param page 
	 * @param search
	 * @return
	 */
	PageInfo<Music> searchMusic(Integer page, Integer limit, String keyword);
	/**
	 * 查询音乐名称放入select中
	 * @return
	 */
	ArrayList selectMusicListToSelect();
	
	/**
	 * 通过音乐歌曲id修改音乐歌曲的歌单id
	 * @param musicId
	 * @param id
	 */
	void updataSongSheetId(String songSheetId, String id);
	
	/**
	 * 查询最新的8条数据
	 * @return
	 */
	PageInfo<Music> showNewMusicList();
	/**
	 * 查询排行榜5条数据
	 * @return
	 */
	PageInfo<Music> selectRankList();
	/**
	 * 增加歌词地址
	 * @param lyricFile
	 * @param id
	 */
	void updateMusicLyric(String lyricFile, String id);
	/**
	 * 查询民谣分类音乐
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showBallad(Integer page, Integer limit);
	/**
	 * 查询流行分类
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showPopular(Integer page, Integer limit);
	/**
	 * 查询纯音乐分类
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showAbsolute(Integer page, Integer limit);
	/**
	 * 查询布鲁斯分类
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showBlues(Integer page, Integer limit);
	/**
	 * 查询古典音乐分类
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showClassical(Integer page, Integer limit);
	/**
	 * 查询嘻哈分类
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showHiphop(Integer page, Integer limit);
	/**
	 * 根据歌手查询歌曲列表
	 * @param musicSinger
	 * @return
	 */
	List<Music> showMusicListBySingerName(String musicSinger);
	/**
	 * 根据歌手姓名查询歌曲信息
	 * @param musicSinger
	 * @return
	 */
	Music showMusicBySingerName(String musicSinger);
	/**
	 * 根据专辑id查询属于专辑的音乐
	 * @param albumId
	 * @return
	 */
	List<Music> selectMusicListByAlbumId(String albumId);
	/**
	 * 查询歌曲数
	 * @return
	 */
	Integer count();
	/**
	 * 通过歌曲名称获取歌曲信息
	 * @param musicName
	 * @return
	 */
	Music selectMusicByMusicName(String musicName);
	/**
	 * 通过歌曲id查询歌曲信息
	 * @param musicid
	 * @return 
	 */
	Music selectMusicById(Integer musicid);
}
