
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.SingerMapper;
import cn.zh.ep.pojo.SingerExample;
import cn.zh.ep.pojo.SingerExample.Criteria;
import cn.zh.ep.pojo.SingerWithBLOBs;
import cn.zh.ep.service.SingerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月9日 下午11:42:27 

* 说明 ：

*/
@Service
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerMapper singerMapper;
	
	@Override
	public void addSinger(SingerWithBLOBs singer) {
		singerMapper.insert(singer);
	}

	@Override
	public PageInfo<SingerWithBLOBs> showSingerListByPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		SingerExample example = new SingerExample();
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example);
		PageInfo<SingerWithBLOBs> info = new PageInfo<SingerWithBLOBs>(list);
		return info;
	}

	@Override
	public SingerWithBLOBs selectSingerById(String singerId) {
		int parseInt = Integer.parseInt(singerId);
		SingerWithBLOBs singer = singerMapper.selectByPrimaryKey(parseInt);
		return singer;
	}

	@Override
	public void editSinger(SingerWithBLOBs singer) {
		singerMapper.updateByPrimaryKeyWithBLOBs(singer);
	}

	@Override
	public void delSingerById(String singerId) {
		int parseInt = Integer.parseInt(singerId);
		singerMapper.deleteByPrimaryKey(parseInt);
	}

	@Override
	public PageInfo<SingerWithBLOBs> searchSinger(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page, limit);
		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		if (keyword != null && !"".equals(keyword)) {
			criteria.andSingerLike("%" + keyword + "%");
		}
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example);
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public SingerWithBLOBs selectSingerBySingerName(String musicSinger) throws Exception {
		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingerEqualTo(musicSinger);
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example);
		SingerWithBLOBs singer = list.get(0);
		return singer;
	}

	@Override
	public Integer count() {
		SingerExample example = new SingerExample();
		Integer singer = singerMapper.countByExample(example );
		return singer;
	}
}
