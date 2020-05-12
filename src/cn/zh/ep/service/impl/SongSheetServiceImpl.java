
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.zh.ep.mapper.SongsheetMapper;
import cn.zh.ep.pojo.Songsheet;
import cn.zh.ep.pojo.SongsheetExample;
import cn.zh.ep.pojo.SongsheetExample.Criteria;
import cn.zh.ep.service.SongSheetService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月11日 下午10:15:47 

* 说明 ：

*/
@Service
public class SongSheetServiceImpl implements SongSheetService{

	@Autowired
	private SongsheetMapper songsheetMapper;
	
	@Override
	public void addSongSheet(Songsheet songsheet) {
		songsheetMapper.insert(songsheet);
	}

	@Override
	public PageInfo<Songsheet> showSongSheetList(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		SongsheetExample example = new SongsheetExample();
		List<Songsheet> list = songsheetMapper.selectByExample(example);
		PageInfo<Songsheet> info = new PageInfo<Songsheet>(list);
		return info;
	}

	@Override
	public Songsheet selectSongSheetById(String songSheetId) {
		int parseInt = Integer.parseInt(songSheetId);
		Songsheet songSheet = songsheetMapper.selectByPrimaryKey(parseInt);
		return songSheet;
	}

	@Override
	public void editSongSheetById(Songsheet songSheet) {
		songsheetMapper.updateByPrimaryKey(songSheet);
	}

	@Override
	public void delSongSheetById(String songSheetId) {
		int parseInt = Integer.parseInt(songSheetId);
		songsheetMapper.deleteByPrimaryKey(parseInt);
	}

	@Override
	public PageInfo<Songsheet> searchResult(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page, limit);
		SongsheetExample example = new SongsheetExample();
		Criteria criteria = example.createCriteria();
		if (keyword != null && !"".equals(keyword)) {
			criteria.andCreatorLike("%"+keyword+"%");
		}
		List<Songsheet> list = songsheetMapper.selectByExample(example);
		PageInfo<Songsheet> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public Integer count() {
		SongsheetExample example = new SongsheetExample();
		Integer songSheet = songsheetMapper.countByExample(example);
		return songSheet;
	}
}
