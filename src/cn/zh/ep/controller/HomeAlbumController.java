
package cn.zh.ep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zh.ep.pojo.Album;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.service.HomeAlbumService;
import cn.zh.ep.service.MusicService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午5:59:00 

* 说明 ：

*/
@Controller
public class HomeAlbumController {

	@Autowired
	private HomeAlbumService homeAlbumService;
	@Autowired
	private MusicService musicService;
	
	
	@RequestMapping(value="/album")
	public String showAlbumList(Model model){
		List<Album> list = homeAlbumService.showAlbumList();
		model.addAttribute("list", list);
		return "album/album";
	}
	
	@RequestMapping(value="/home/showAlbumInfo")
	public String showAlbumInfo(Model model,String albumId,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="8")Integer limit){
		Album album = homeAlbumService.selectAlbumInfo(albumId);
		List<Music> list = musicService.selectMusicListByAlbumId(albumId);
		List<Album> albumList = homeAlbumService.showAlbumList(page,limit);
		model.addAttribute("album",album);
		model.addAttribute("list", list);
		model.addAttribute("albumList", albumList);
		return "album/album-detail";
	}
}
