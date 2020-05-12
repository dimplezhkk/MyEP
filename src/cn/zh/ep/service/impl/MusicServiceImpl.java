
package cn.zh.ep.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.MusicMapper;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.MusicExample;
import cn.zh.ep.pojo.MusicExample.Criteria;
import cn.zh.ep.service.MusicService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月5日 下午7:22:15 

* 说明 ：

*/
@Service
public class MusicServiceImpl implements MusicService{
	
	@Autowired
	private MusicMapper musicMapper;

	@Override
	public void addMusic(Music music) {
		musicMapper.insert(music);
	}

	@Override
	public List<Music> showMusicList() {
		MusicExample example = new MusicExample();
		List<Music> list = musicMapper.selectByExample(example);
		return list;
	}

	@Override
	public PageInfo<Music> showMusicListByPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		//PageHelper.startPage(3, 12, true);
		MusicExample example = new MusicExample();
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<Music>(list);
		return info;
	}

	@Override
	public void delMusicById(String musicId) {
		int parseInt = Integer.parseInt(musicId);
		musicMapper.deleteByPrimaryKey(parseInt);
	}

	@Override
	public Music selectMusicById(String musicId) {
		int parseInt = Integer.parseInt(musicId);
		Music music = musicMapper.selectByPrimaryKey(parseInt);
		return music;
	}

	@Override
	public void editMusic(Music music) {
		musicMapper.updateByPrimaryKey(music);
	}

	@Override
	public PageInfo<Music> searchMusic(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page, limit);
		/*MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();*/
		/*if (keyword != null && !"".equals(keyword)) {
			criteria.andSingerLike("%"+keyword+"%");
		}*/
		List<Music> list = musicMapper.searchList(keyword);
		/*List<Music> list = musicMapper.selectByExampleWithBLOBs(example);*/
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public ArrayList selectMusicListToSelect() {
		ArrayList list = musicMapper.selectMusicListToSelect();
		return list;
	}

	@Override
	public void updataSongSheetId(String songSheetid, String Id) {
		Integer songSheetId = Integer.parseInt(songSheetid);
		Integer id = Integer.parseInt(Id);
		musicMapper.updataSongSheetId(songSheetId,id);
	}

	@Override
	public PageInfo<Music> showNewMusicList() {
		PageHelper.startPage(0, 8);
		MusicExample example = new MusicExample();
		example.setOrderByClause("id DESC");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Music> selectRankList() {
		PageHelper.startPage(0, 5);
		MusicExample example = new MusicExample();
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public void updateMusicLyric(String lyricFile, String Id) {
		Integer id = Integer.parseInt(Id);
		musicMapper.addMusicLyric(lyricFile,id);
	}

	@Override
	public PageInfo<Music> showBallad(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andDescriptionLike("%" + "民谣" + "%");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Music> showPopular(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andDescriptionLike("%" + "流行" + "%");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Music> showAbsolute(Integer page, Integer limit) {
		
		PageHelper.startPage(page, limit);
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andDescriptionLike("%" + "纯音乐" + "%");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Music> showBlues(Integer page, Integer limit) {
		
		PageHelper.startPage(page, limit);
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andDescriptionLike("%" + "布鲁斯" + "%");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Music> showClassical(Integer page, Integer limit) {
		
		PageHelper.startPage(page, limit);
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andDescriptionLike("%" + "古典" + "%");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<Music> showHiphop(Integer page, Integer limit) {
		
		PageHelper.startPage(page, limit);
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andDescriptionLike("%" + "嘻哈" + "%");
		List<Music> list = musicMapper.selectByExample(example);
		PageInfo<Music> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public List<Music> showMusicListBySingerName(String musicSinger) {
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingerEqualTo(musicSinger);
		List<Music> list = musicMapper.selectByExample(example);
		return list;
	}

	@Override
	public Music showMusicBySingerName(String musicSinger) {
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingerEqualTo(musicSinger);
		List<Music> list = musicMapper.selectByExample(example);
		Music music = list.get(0);
		return music;
	}

	@Override
	public List<Music> selectMusicListByAlbumId(String albumId) {
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andAlbumEqualTo(albumId);
		List<Music> list = musicMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer count() {
		MusicExample example = new MusicExample();
		Integer music = musicMapper.countByExample(example );
		return music;
	}

	@Override
	public Music selectMusicByMusicName(String musicName) {
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andMusicnameEqualTo(musicName);
		List<Music> list = musicMapper.selectByExample(example);
		Music music = list.get(0);
		return music;
	}

	@Override
	public Music selectMusicById(Integer musicid) {
		Music music = musicMapper.selectByPrimaryKey(musicid);
		return music;
	}
}
