
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.MusicvideoMapper;
import cn.zh.ep.pojo.Musicvideo;
import cn.zh.ep.pojo.MusicvideoExample;
import cn.zh.ep.service.MusicVideoService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月12日 下午10:22:37 

* 说明 ：

*/
@Service
public class MusicVideoServiceImpl implements MusicVideoService {

	@Autowired
	private MusicvideoMapper musicvideoMapper;
	@Override
	public void addMusicVideo(Musicvideo mv) {
		musicvideoMapper.insert(mv);
		
	}
	@Override
	public PageInfo<Musicvideo> selectMusicVideoList(Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		MusicvideoExample example = new MusicvideoExample();
		List<Musicvideo> list = musicvideoMapper.selectByExample(example);
		PageInfo<Musicvideo> info = new PageInfo<>(list);
		return info;
	}
	@Override
	public Musicvideo selectMusicVideoById(String mvId) {
		int parseInt = Integer.parseInt(mvId);
		Musicvideo musicVideo = musicvideoMapper.selectByPrimaryKey(parseInt);
		return musicVideo;
	}
	@Override
	public void selectMusicVideoById(Musicvideo mv) {
		musicvideoMapper.updateByPrimaryKey(mv);
	}
	@Override
	public void delMusicVideoById(String mvId) {
		int parseInt = Integer.parseInt(mvId);
		musicvideoMapper.deleteByPrimaryKey(parseInt);
	}
	@Override
	public PageInfo<Musicvideo> searchResult(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page, limit);
		List<Musicvideo> list =  musicvideoMapper.searchResult(keyword);
		PageInfo<Musicvideo> info = new PageInfo<>(list);
		return info;
	}
	@Override
	public Integer count() {
		MusicvideoExample example = new MusicvideoExample();
		Integer mv = musicvideoMapper.countByExample(example);
		return mv;
	}
}
