
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.RotationMapper;
import cn.zh.ep.pojo.Rotation;
import cn.zh.ep.pojo.RotationExample;
import cn.zh.ep.service.RotationService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月17日 上午11:44:07 

* 说明 ：
*/
@Service
public class RotationServiceImpl implements RotationService{

	@Autowired
	private RotationMapper rotationMapper;
	@Override
	public void addRotation(Rotation rotation) {
		rotationMapper.insert(rotation);
	}
	@Override
	public PageInfo<Rotation> selectRotationList(Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		RotationExample example = new RotationExample();
		List<Rotation> list = rotationMapper.selectByExample(example );
		PageInfo<Rotation> info = new PageInfo<>(list);
		return info;
	}
	@Override
	public Rotation selectRotationById(String rotationId) {
		Rotation rotation = rotationMapper.selectByPrimaryKey(Integer.parseInt(rotationId));
		return rotation;
	}
	@Override
	public void editRotation(Rotation rotation) {
		rotationMapper.updateByPrimaryKey(rotation);
	}
	@Override
	public void delRotationById(String rotationId) {
		rotationMapper.deleteByPrimaryKey(Integer.parseInt(rotationId));
	}
	@Override
	public List<Rotation> selectRotationList() {
		
		RotationExample example = new RotationExample();
		List<Rotation> list = rotationMapper.selectByExample(example );
		return list;
	}
}
