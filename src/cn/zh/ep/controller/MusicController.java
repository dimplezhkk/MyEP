
package cn.zh.ep.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Music;
import cn.zh.ep.service.AlbumService;
import cn.zh.ep.service.MusicService;
import net.sf.json.JSONArray;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月5日 上午10:34:30 

* 说明 ：

*/
@Controller
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("/music/music-add")
	public String musicAdd(Model model){
		ArrayList list = albumService.selectAlbumListToSelect();
		model.addAttribute("list", list);
		return "music/music-add";
	}
	
	@RequestMapping(value="/music/addMusic",method=RequestMethod.POST)
	public void addMusic(HttpServletRequest request,
			@RequestParam("url") MultipartFile file,@RequestParam("image") MultipartFile image) throws Exception{
		Music music = new Music();
		music.setMusicname(request.getParameter("musicname"));
		music.setSinger(request.getParameter("singer"));
		music.setAlbum(request.getParameter("album"));
		music.setDescription(request.getParameter("description"));
		music.setLyric(request.getParameter("lyric"));
		String filename = file.getOriginalFilename();
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+filename),true);
		music.setUrl("audio/" + filename);
		String imageFilename = image.getOriginalFilename();
		Streams.copy(image.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+imageFilename),true);
		music.setImage("audio/" + imageFilename);
		
		musicService.addMusic(music);
	}
	@RequestMapping(value = "/music/music-list",method = RequestMethod.GET)
	//@ResponseBody
	public String showMusicList(Model model,
			@RequestParam(required = false, defaultValue = "6")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page){
		PageInfo<Music> info =  musicService.showMusicListByPage(page,limit);
		model.addAttribute("pageInfo", info);
		return "music/music-list";
	}

	@RequestMapping(value="/music/music-del",method=RequestMethod.POST)
	@ResponseBody
	public void delMusic(String musicId){
		musicService.delMusicById(musicId);
	}
	@RequestMapping("/music/music-edit")
	public String editMusic(String musicId,Model model){
		Music music = musicService.selectMusicById(musicId);
		ArrayList list = albumService.selectAlbumListToSelect();
		model.addAttribute("list", list);
		model.addAttribute("music", music);
		return "music/music-edit";
	}
	
	@RequestMapping(value="/music/editMusic",method=RequestMethod.POST)
	public void editMusic(HttpServletRequest request,
			@RequestParam("url") MultipartFile file,
			@RequestParam("image") MultipartFile image) throws Exception{
		Music music = new Music();
		music.setId(Integer.parseInt(request.getParameter("id")));
		music.setMusicname(request.getParameter("musicname"));
		music.setSinger(request.getParameter("singer"));
		music.setAlbum(request.getParameter("album"));
		music.setDescription(request.getParameter("description"));
		music.setLyric(request.getParameter("lyric"));
		String filename = file.getOriginalFilename();
		//保存文件
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+filename),true);
		music.setUrl("audio/" + filename);
		String imageFilename = image.getOriginalFilename();
		Streams.copy(image.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+imageFilename),true);
		music.setImage("audio/" + imageFilename);
		musicService.editMusic(music);
	}
	
	
	@RequestMapping(value = "/music/music-search",method=RequestMethod.POST)
	public String searchResult(Model model,
			@RequestParam(required = false, defaultValue = "6")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page,String keyword){
		PageInfo<Music> info = musicService.searchMusic(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "music/music-search";
	}
	
	@RequestMapping(value="/music/addAlbum",method=RequestMethod.POST)
	@ResponseBody
	public JSONArray selectAlbumListToSelect(){
		ArrayList list = albumService.selectAlbumListToSelect();
		if (list == null) {
			return null;
		}
		//转换
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray;
	}
}
