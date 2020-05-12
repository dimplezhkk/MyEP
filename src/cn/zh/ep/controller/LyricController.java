
package cn.zh.ep.controller;


import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Music;
import cn.zh.ep.service.MusicService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月14日 下午2:07:00 

* 说明 ：歌词管理

*/
@Controller
public class LyricController {
	
	@Autowired
	private MusicService musicService;
	
	@RequestMapping(value="/music/lyric-list")
	public String showLyricList(Model model,
			@RequestParam(required=false,defaultValue="1") Integer page,
			@RequestParam(required=false,defaultValue="7") Integer limit){
			PageInfo<Music> info = musicService.showMusicListByPage(page, limit);
			model.addAttribute("pageInfo", info);
		return "lyric/lyric-list";
	}
	
	@RequestMapping(value="/music/lyric-edit")
	public String addLyricForMusic(Model model,String musicId){
		Music music = musicService.selectMusicById(musicId);
		model.addAttribute("music", music);
		return "lyric/lyric-edit";
	}
	
	@RequestMapping(value="/music/editLyric",method=RequestMethod.POST)
	public void addLyricToMusic(HttpServletRequest request,
			@RequestParam("lyric")MultipartFile lyric) throws Exception{
		String id = request.getParameter("id");
		String filename = lyric.getOriginalFilename();
		Streams.copy(lyric.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+filename), true);
		String lyricFile = "audio/" + filename;
		musicService.updateMusicLyric(lyricFile,id);
		
	}
	
	@RequestMapping(value="/music/lyric-search",method=RequestMethod.POST)
	public String searchResult(Model model,
			@RequestParam(required=false,defaultValue="1") Integer page,
			@RequestParam(required=false,defaultValue="7") Integer limit,String keyword){
		PageInfo<Music> info = musicService.searchMusic(page, limit, keyword);
		model.addAttribute("pageInfo", info);
		
		return "lyric/lyric-search";
	}
}
