
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.MusicvideoMapper;
import cn.zh.ep.pojo.Musicvideo;
import cn.zh.ep.pojo.MusicvideoExample;
import cn.zh.ep.pojo.MusicvideoExample.Criteria;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月16日 下午3:41:06 

* 说明 ：

*/
@Service
public class HomeMusicVideoService implements cn.zh.ep.service.HomeMusicVideoService {

	@Autowired
	private MusicvideoMapper musicvideoMapper;
	@Override
	public PageInfo<Musicvideo> selectThreeNewMusicVideo(Integer page, Integer limit) {
		PageHelper.startPage(1,3);
		MusicvideoExample example = new MusicvideoExample();
		example.setOrderByClause("id DESC");
		List<Musicvideo> list = musicvideoMapper.selectByExample(example);
		PageInfo<Musicvideo> info = new PageInfo<>(list);
		return info;
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
	public List<Musicvideo> selectMusicVideoBySingerName(String singer) {
		PageHelper.startPage(1, 8);
		MusicvideoExample example = new MusicvideoExample();
		example.setOrderByClause("id DESC");
		Criteria criteria = example.createCriteria();
		criteria.andSingerEqualTo(singer);
		List<Musicvideo> list = musicvideoMapper.selectByExample(example );
		
		return list;
	}
}
