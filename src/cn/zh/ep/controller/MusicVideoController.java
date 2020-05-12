
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import cn.zh.ep.pojo.Musicvideo;
import cn.zh.ep.service.MusicVideoService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月12日 下午7:28:02 

* 说明 ：

*/
@Controller
public class MusicVideoController {

	@Autowired
	private MusicVideoService musicVideoService;
	
	@RequestMapping(value="/mv/mv-list")
	public String showMvList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="5")Integer limit){
		PageInfo<Musicvideo> info = musicVideoService.selectMusicVideoList(page,limit);
		model.addAttribute("pageInfo", info);
		return "mv/mv-list";
	}
	
	@RequestMapping(value="/mv/mv-add")
	public String addMusicVideo(){
		
		return "mv/mv-add";
	}
	
	@RequestMapping(value="/mv/addMusicVideo",method=RequestMethod.POST)
	public void addMusicVideo(HttpServletRequest request,
		@RequestParam("video") MultipartFile video,
		@RequestParam("image") MultipartFile image) throws Exception{
		Musicvideo mv = new Musicvideo();
		mv.setAge(request.getParameter("age"));
		mv.setArea(request.getParameter("area"));
		mv.setHot(request.getParameter("hot"));
		mv.setName(request.getParameter("name"));
		mv.setSinger(request.getParameter("singer"));
		mv.setType(request.getParameter("type"));
		
		String videoFilename = video.getOriginalFilename();
		Streams.copy(video.getInputStream(), new FileOutputStream("E:\\upload\\mv\\"+videoFilename), true);
		mv.setVideo("mv/"+videoFilename);
		String imageFilename = image.getOriginalFilename();
		Streams.copy(image.getInputStream(), new FileOutputStream("E:\\upload\\mv\\"+imageFilename), true);
		mv.setImage("mv/"+imageFilename);
		musicVideoService.addMusicVideo(mv);
	}
	
	@RequestMapping(value="/mv/mv-edit")
	public String showEditMUsicVideoPage(Model model,String mvId){
		Musicvideo musicVideo = musicVideoService.selectMusicVideoById(mvId);
		model.addAttribute("mv", musicVideo);
		return "mv/mv-edit";
	}
	
	@RequestMapping(value="/mv/editMusicVideo",method=RequestMethod.POST)
	public void editMusicVideo(HttpServletRequest request,
			@RequestParam("video") MultipartFile video,
			@RequestParam("image") MultipartFile image) throws Exception{
		Musicvideo mv = new Musicvideo();
		mv.setAge(request.getParameter("age"));
		mv.setArea(request.getParameter("area"));
		mv.setHot(request.getParameter("hot"));
		mv.setId(Integer.parseInt(request.getParameter("id")));
		mv.setName(request.getParameter("name"));
		mv.setSinger(request.getParameter("singer"));
		mv.setType(request.getParameter("type"));
		
		String videoFilename = video.getOriginalFilename();
		Streams.copy(video.getInputStream(), new FileOutputStream("E:\\upload\\mv\\"+videoFilename), true);
		mv.setVideo("mv/"+videoFilename);
		String imageFilename = image.getOriginalFilename();
		Streams.copy(image.getInputStream(), new FileOutputStream("E:\\upload\\mv\\"+imageFilename), true);
		mv.setImage("mv/"+imageFilename);
		
		musicVideoService.selectMusicVideoById(mv);
		
	}
	
	@RequestMapping(value="/mv/mv-del",method=RequestMethod.POST)
	@ResponseBody
	public void delMusicVideoById(String mvId){
		musicVideoService.delMusicVideoById(mvId);
		
	}
	
	@RequestMapping(value="/mv/mv-search",method=RequestMethod.POST)
	public String searchResult(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="5")Integer limit,String keyword) {
		PageInfo<Musicvideo> info = musicVideoService.searchResult(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "mv/mv-search";
	}
}
