
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

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��15�� ����2:37:22 

* ˵�� ��

*/
@Service
public class HomeSingerServiceImpl implements HomeSingerService {

	@Autowired
	private SingerMapper singerMapper;

	@Override
	public PageInfo<SingerWithBLOBs> showhySingerListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("�������");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showhyComposeListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("�������");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showrhSingerListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("�պ�����");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showrhComposeListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("�պ����");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showomSingerListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("ŷ������");
		List<SingerWithBLOBs> list = singerMapper.selectByExampleWithBLOBs(example );
		PageInfo<SingerWithBLOBs> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public PageInfo<SingerWithBLOBs> showomComposeListByPage(Integer page, Integer limit) {

		SingerExample example = new SingerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingertypeEqualTo("ŷ�����");
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
