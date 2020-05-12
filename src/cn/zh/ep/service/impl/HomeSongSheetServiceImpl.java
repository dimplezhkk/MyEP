
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.ep.mapper.SongsheetMapper;
import cn.zh.ep.pojo.Songsheet;
import cn.zh.ep.pojo.SongsheetExample;
import cn.zh.ep.pojo.SongsheetExample.Criteria;
import cn.zh.ep.service.HomeSongSheetService;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��15�� ����11:02:50 

* ˵�� ��

*/
@Service
public class HomeSongSheetServiceImpl implements HomeSongSheetService{

	@Autowired
	private SongsheetMapper songsheetMapper;
	@Override
	public Songsheet selectNewOneSongSheet() {
		SongsheetExample example = new SongsheetExample();
		example.setOrderByClause("id desc");
		List<Songsheet> list = songsheetMapper.selectByExample(example);
		Songsheet songsheet = list.get(0);
		return songsheet;
	}
	@Override
	public List<Songsheet> selectSongSheetList() {
		SongsheetExample example = new SongsheetExample();
		List<Songsheet> list = songsheetMapper.selectByExample(example);
		return list;
	}
	@Override
	public Songsheet selectSongSheetBy(String songSheetId) {
		int parseInt = Integer.parseInt(songSheetId);
		Songsheet songsheet = songsheetMapper.selectByPrimaryKey(parseInt);
		return songsheet;
	}
}
