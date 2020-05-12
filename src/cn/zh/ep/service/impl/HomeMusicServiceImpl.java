
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.ep.mapper.MusicMapper;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.MusicExample;
import cn.zh.ep.pojo.MusicExample.Criteria;
import cn.zh.ep.service.HomeMusicService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午11:10:29 

* 说明 ：

*/
@Service
public class HomeMusicServiceImpl implements HomeMusicService {

	@Autowired
	private MusicMapper musicMapper;
	@Override
	public List<Music> selectMusicListBySongSheetId(Integer id) {
		MusicExample example = new MusicExample();
		Criteria criteria = example.createCriteria();
		criteria.andSongsheetidEqualTo(id);
		List<Music> list = musicMapper.selectByExample(example);
		return list;
	}
}
