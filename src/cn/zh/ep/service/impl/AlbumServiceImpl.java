
package cn.zh.ep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.AlbumMapper;
import cn.zh.ep.pojo.Album;
import cn.zh.ep.pojo.AlbumExample;
import cn.zh.ep.pojo.AlbumExample.Criteria;
import cn.zh.ep.service.AlbumService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月10日 下午10:49:38 

* 说明 ：

*/

@Service
public class AlbumServiceImpl implements AlbumService{
	
	@Autowired
	private AlbumMapper albumMapper;

	@Override
	public void addAlbum(Album album) {
		albumMapper.insert(album);
	}

	@Override
	public PageInfo<Album> showAlbumListByPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		AlbumExample example = new AlbumExample();
		List<Album> list = albumMapper.selectByExampleWithBLOBs(example);
		PageInfo<Album> info = new PageInfo<Album>(list);
		return info;
	}

	@Override
	public Album editAlbum(String albumId) {
		int parseInt = Integer.parseInt(albumId);
		Album album = albumMapper.selectByPrimaryKey(parseInt);
		return album;
	}

	@Override
	public void editAlbumById(Album album) {
		albumMapper.updateByPrimaryKeyWithBLOBs(album);
	}

	@Override
	public void delAlbum(String albumId) {
		int parseInt = Integer.parseInt(albumId);
		albumMapper.deleteByPrimaryKey(parseInt);
	}

	@Override
	public PageInfo<Album> searchResult(Integer page, Integer limit, String keyword) {
		PageHelper.startPage(page,limit);
		List<Album> list = albumMapper.searchAlbum(keyword);
		PageInfo<Album> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public ArrayList selectAlbumListToSelect() {
		ArrayList list = albumMapper.selectAlbumListToSelect();
		return list;
	}

	@Override
	public List<Album> showAlbumListBySingerName(String singer) {
		AlbumExample example = new AlbumExample();
		Criteria criteria = example.createCriteria();
		criteria.andSingerEqualTo(singer);
		List<Album> list = albumMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public Integer count() {
		AlbumExample example = new AlbumExample();
		Integer album = albumMapper.countByExample(example);
		return album;
	}
}
