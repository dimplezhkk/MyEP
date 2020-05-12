
package cn.zh.ep.controller;

import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Album;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.Musicvideo;
import cn.zh.ep.pojo.SingerWithBLOBs;
import cn.zh.ep.service.AlbumService;
import cn.zh.ep.service.HomeSingerService;
import cn.zh.ep.service.MusicService;
import cn.zh.ep.service.MusicVideoService;
import cn.zh.ep.utils.readLyrics;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月13日 下午12:03:06 

* 说明 ：

*/
@Controller
public class HomeIndexController {
	
	@Autowired
	private MusicService musicService;
	@Autowired
	private HomeSingerService homeSingerService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private MusicVideoService musicVideoService;
	@RequestMapping(value="/home")
	public String showHomeIndex(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showMusicListByPage(page, limit);
		PageInfo<Music> newMusic = musicService.showNewMusicList();
		PageInfo<Music> rank = musicService.selectRankList();
		model.addAttribute("pageInfo", info);
		model.addAttribute("newInfo", newMusic);
		model.addAttribute("rank", rank);
		return "home/index";
	}
	
	@RequestMapping(value="/home/showMusic")
	public String showMusicPage(Model model,String musicId){
		Music music = musicService.selectMusicById(musicId);
		String singer = music.getSinger();
		List<Music> list = musicService.showMusicListBySingerName(singer);
		model.addAttribute("list", list);
		model.addAttribute("music", music);
		return "home/musicPlay";
	}
	
	@RequestMapping(value="/home/lyrics",method=RequestMethod.GET)
	public void showLyrics(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String songname = request.getParameter("name");
		readLyrics rl = new readLyrics(songname);
		String lyrics = rl.getLyrics();
		response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        if (lyrics != "") {
            out.write(lyrics);
        }
        else{
            String error = "error";
            out.write(error);
        }
	}
	
	@RequestMapping(value="/home/search")
	public String searchResult(Model model,String keyword){
		PageInfo<Music> info = musicService.searchMusic(1, 10, keyword);
		List<SingerWithBLOBs> singer = homeSingerService.searchSinger(keyword);
		PageInfo<Album> pageInfo = albumService.searchResult(1, 10, keyword);
		PageInfo<Musicvideo> result = musicVideoService.searchResult(1, 10, keyword);
		model.addAttribute("pageInfo", info);
		model.addAttribute("singer", singer);
		model.addAttribute("album", pageInfo);
		model.addAttribute("mv", result);
		return "home/search";
	}
	
}
