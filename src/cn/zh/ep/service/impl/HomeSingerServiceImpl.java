
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.SingerMapper;
import cn.zh.ep.pojo.SingerExample;
import cn.zh.ep.pojo.SingerExample.Criteria;
import cn.zh.ep.pojo.SingerWithBLOBs;
import cn.zh.ep.service.HomeSingerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午2:37:22 

* 说明 ：

*/
@Service
public class HomeSingerServiceImpl implements HomeSingerService {

	@Autowired
	private SingerMapper singerMapper;

	@Override
	public PageInfo<SingerWithBLOBs> showhySingerListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("华语歌手");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showhyComposeListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("华语组合");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showrhSingerListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("日韩歌手");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showrhComposeListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("日韩组合");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showomSingerListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("欧美歌手");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showomComposeListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("欧美组合");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public List<SingerWithBLOBs> searchSinger(String keyword) {
		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingerLike("%" + keyword + "%");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example);
		return list;
	}

}
