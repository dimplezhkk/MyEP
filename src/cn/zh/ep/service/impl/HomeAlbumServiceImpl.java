
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.zh.ep.mapper.AlbumMapper;
import cn.zh.ep.pojo.Album;
import cn.zh.ep.pojo.AlbumExample;
import cn.zh.ep.pojo.AlbumExample.Criteria;
import cn.zh.ep.service.HomeAlbumService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午7:04:13 

* 说明 ：

*/
@Service
public class HomeAlbumServiceImpl implements HomeAlbumService {

	@Autowired
	private AlbumMapper albumMapper;
	@Override
	public List<Album> showAlbumList() {
		AlbumExample example = new AlbumExample();
		List<Album> list = albumMapper.selectByExampleWithBLOBs(example);
		return list;
	}
	@Override
	public Album selectAlbumInfo(String albumId) {
		Integer parseInt = Integer.parseInt(albumId);
		Album album = albumMapper.selectByPrimaryKey(parseInt);
		return album;
	}
	
	@Override
	public List<Album> showAlbumList(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		AlbumExample example = new AlbumExample();
		example.setOrderByClause("id DESC");
		List<Album> albums = albumMapper.selectByExampleWithBLOBs(example);
		return albums;
	}
}
