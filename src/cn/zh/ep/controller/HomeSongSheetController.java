
package cn.zh.ep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.Songsheet;
import cn.zh.ep.service.HomeMusicService;
import cn.zh.ep.service.HomeSongSheetService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月15日 下午10:51:51 

* 说明 ：前台歌单管理

*/
@Controller
public class HomeSongSheetController {
	
	@Autowired
	private HomeSongSheetService homeSongSheetService;
	@Autowired
	private HomeMusicService homeMusicService;
	
	@RequestMapping(value="/SongSheet")
	public String showSongSheetList(Model model){
		Songsheet songsheet = homeSongSheetService.selectNewOneSongSheet();
		Integer id = songsheet.getId();
		List<Music> list = homeMusicService.selectMusicListBySongSheetId(id);
		List<Songsheet> songsheetList = homeSongSheetService.selectSongSheetList();
		model.addAttribute("songSheet", songsheet);
		model.addAttribute("list", list);
		model.addAttribute("songSheetList", songsheetList);
		return "songSheet/songSheet";
	}
	
	@RequestMapping(value="/home/showSongSheet")
	public String showSongSheetListById(Model model,String songSheetId){
		try {
			
		Songsheet songsheet = homeSongSheetService.selectSongSheetBy(songSheetId);
		Integer id = songsheet.getId();
		List<Music> list = homeMusicService.selectMusicListBySongSheetId(id);
		List<Songsheet> songsheetList = homeSongSheetService.selectSongSheetList();
		model.addAttribute("songSheet", songsheet);
		model.addAttribute("list", list);
		model.addAttribute("songSheetList", songsheetList);
		return "songSheet/songSheetById";
		} catch (Exception e) {
			return "songSheet/songSheet";
		}
	}

}
