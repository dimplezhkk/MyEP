
package cn.zh.ep.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import cn.zh.ep.pojo.Songsheet;
import cn.zh.ep.service.MusicService;
import cn.zh.ep.service.SongSheetService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月11日 下午9:10:15 

* 说明 ：

*/
@Controller
public class SongSheetController {
	
	@Autowired
	private SongSheetService songSheetService;
	@Autowired
	private MusicService musicService;
	
	
	@RequestMapping(value="/songSheet/songSheet_list")
	public String showSongSheetList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="5")Integer limit){
		PageInfo<Songsheet> info = songSheetService.showSongSheetList(page,limit);
		model.addAttribute("pageInfo", info);
		return "songSheet/songSheet-list";
	}
	
	@RequestMapping(value="/songSheet/songSheet-add")
	public String addSongSheet(){
		
		return "songSheet/songSheet-add";
	}
	
	@RequestMapping(value="/songSheet/addSongSheet",method=RequestMethod.POST)
	public void addSongSheet(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("url") MultipartFile file) throws Exception{
		Songsheet songsheet = new Songsheet();
		
		songsheet.setCreator(request.getParameter("creator"));
		songsheet.setDescription(request.getParameter("description"));
		songsheet.setHot(request.getParameter("hot"));
		songsheet.setLabel(request.getParameter("label"));
		
		String filename = file.getOriginalFilename();
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\songSheet\\"+filename), true);
		songsheet.setImage("songSheet/" + filename);
		
		songSheetService.addSongSheet(songsheet);
	}
	
	@RequestMapping(value="/songSheet/songSheet-edit")
	public String editSongSheet(Model model,String songSheetId){
		Songsheet songSheet = songSheetService.selectSongSheetById(songSheetId);
		model.addAttribute("songSheet", songSheet);
		return "songSheet/songSheet-edit";
		
	}
	
	@RequestMapping(value="/songSheet/editSongSheet",method=RequestMethod.POST)
	public void editSongSheetById(HttpServletRequest request,@RequestParam("url")MultipartFile file)throws Exception{
		Songsheet songSheet = new Songsheet();
		songSheet.setId(Integer.parseInt(request.getParameter("id")));
		songSheet.setCreator(request.getParameter("creator"));
		songSheet.setDescription(request.getParameter("description"));
		songSheet.setHot(request.getParameter("hot"));
		songSheet.setLabel(request.getParameter("label"));
		String filename = file.getOriginalFilename();
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\songSheet\\"+filename), true);
		songSheet.setImage("songSheet/"+filename);
		songSheetService.editSongSheetById(songSheet);
	}
	
	@RequestMapping(value="/songSheet/songSheet-del",method=RequestMethod.POST)
	@ResponseBody
	public void delSongSheetById(String songSheetId){
		songSheetService.delSongSheetById(songSheetId);
	}
	
	@RequestMapping(value="/songSheet/songSheet-search",method=RequestMethod.POST)
	public String searchResult(@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="5")Integer limit,String keyword,Model model){
		PageInfo<Songsheet> info = songSheetService.searchResult(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "songSheet/songSheet-search";
		
	}
	
	@RequestMapping(value="/addMusicToSongSheet")
	public String showAddMusicToSongSheetPage(Model model,String songSheetId){
		Songsheet songSheet = songSheetService.selectSongSheetById(songSheetId);
		Integer id = songSheet.getId();
		ArrayList list = musicService.selectMusicListToSelect();
		model.addAttribute("songSheetId", id);
		model.addAttribute("list", list);
		return "songSheet/add_music_to_songSheet";
	}
	
	@RequestMapping(value="/songSheet/addMusicToSongSheet",method=RequestMethod.POST)
	@ResponseBody
	public void addMusicToSongSheet(HttpServletRequest request){
		String id = request.getParameter("id");
		String songSheetId = request.getParameter("songSheetId");
		/*System.err.println(id);
		System.err.println(songSheetId);*/
		musicService.updataSongSheetId(songSheetId,id);
	}
}
