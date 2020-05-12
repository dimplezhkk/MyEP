
package cn.zh.ep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Album;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.SingerWithBLOBs;
import cn.zh.ep.service.AlbumService;
import cn.zh.ep.service.HomeSingerService;
import cn.zh.ep.service.MusicService;
import cn.zh.ep.service.SingerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午12:44:11 

* 说明 ：

*/
@Controller
public class HomeSingerController {
	
	@Autowired
	private SingerService singerService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private HomeSingerService homeSingerService;
	@Autowired
	private AlbumService albumService;
	
	
	@RequestMapping(value="/singer")
	public String showSingerList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = singerService.showSingerListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/singer";
	}
	@RequestMapping(value="/hySinger")
	public String showhySingerList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = homeSingerService.showhySingerListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/hySinger";
	}
	@RequestMapping(value="/hyCompose")
	public String showhyComposeList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = homeSingerService.showhyComposeListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/hyCompose";
	}
	@RequestMapping(value="/rhSinger")
	public String showrhSingerList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = homeSingerService.showrhSingerListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/rhSinger";
	}
	@RequestMapping(value="/rhCompose")
	public String showrhComposeList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = homeSingerService.showrhComposeListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/rhCompose";
	}
	@RequestMapping(value="/omSinger")
	public String showomSingerList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = homeSingerService.showomSingerListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/omSinger";
	}
	@RequestMapping(value="/omCompose")
	public String showomComposeList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<SingerWithBLOBs> info = homeSingerService.showomComposeListByPage(page, limit);
		model.addAttribute("pageInfo", info);
		return "singer/omCompose";
	}
	
	@RequestMapping(value="/home/showSingerInfo")
	public String showSingerInfo(Model model,String singer){
		try {
		List<Music> list = musicService.showMusicListBySingerName(singer);
		SingerWithBLOBs singerName = singerService.selectSingerBySingerName(singer);
		Music music = musicService.showMusicBySingerName(singer);
		String description = music.getDescription();
		List<Album> albums = albumService.showAlbumListBySingerName(singer);
		model.addAttribute("list", list);
		model.addAttribute("singer", singerName);
		model.addAttribute("description", description);
		model.addAttribute("album", albums);
		} catch (Exception e) {
			return "home/error";
		}
		return "singer/singer-detail";
	}
}
