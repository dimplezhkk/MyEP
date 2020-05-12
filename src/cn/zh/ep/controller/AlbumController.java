
package cn.zh.ep.controller;

import java.io.FileOutputStream;

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

import cn.zh.ep.pojo.Album;
import cn.zh.ep.service.AlbumService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月10日 下午9:00:35 

* 说明 ：

*/
@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value="/album/album-list")
	public String showAlbumList(Model model,
			@RequestParam(required = false, defaultValue = "5")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page){
		PageInfo<Album> info = albumService.showAlbumListByPage(page,limit);
		model.addAttribute("pageInfo", info);
		return "album/album-list";
	}
	
	@RequestMapping(value="/album/album-add")
	public String addAlbum(){
		
		return "album/album-add";
	}
	
	@RequestMapping(value="/album/addAlbum",method=RequestMethod.POST)
	public void addAlbum(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("url") MultipartFile file) throws Exception{
		Album album = new Album();
		album.setName(request.getParameter("name"));
		album.setSinger(request.getParameter("singer"));
		album.setArea(request.getParameter("area"));
		album.setHot(request.getParameter("hot"));
		album.setSchools(request.getParameter("schools"));
		album.setAge(request.getParameter("age"));
		/*String realPath = request.getServletContext().getRealPath("");
		String path = realPath.substring(0, realPath.lastIndexOf("\\"));
		System.out.println(path);*/
		//获取文件名
		String filename = file.getOriginalFilename();
		//保存文件
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\album\\"+filename), true);
        album.setImage("album/" + filename);
        
       albumService.addAlbum(album);
	}
	
	@RequestMapping(value="/album/album-edit")
	public String editAlbum(Model model,String albumId){
		
		Album album = albumService.editAlbum(albumId);
		model.addAttribute("album", album);
		return "album/album-edit";
	}
	
	@RequestMapping(value="/album/editAlbum",method=RequestMethod.POST)
	public void editAlbum(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("url") MultipartFile file) throws Exception{
		Album album = new Album();
		album.setId(Integer.parseInt(request.getParameter("id")));
		album.setName(request.getParameter("name"));
		album.setSinger(request.getParameter("singer"));
		album.setArea(request.getParameter("area"));
		album.setHot(request.getParameter("hot"));
		album.setSchools(request.getParameter("schools"));
		album.setAge(request.getParameter("age"));
		/*String realPath = request.getServletContext().getRealPath("");
		String path = realPath.substring(0, realPath.lastIndexOf("\\"));
		System.out.println(path);*/
		//获取文件名
		String filename = file.getOriginalFilename();
		//保存文件
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\album\\"+filename), true);
        album.setImage("album/" + filename);
		albumService.editAlbumById(album);
	}
	
	@RequestMapping(value="/album/album-del",method=RequestMethod.POST)
	@ResponseBody
	public void delAlbum(String albumId){
		albumService.delAlbum(albumId);
	}

	@RequestMapping(value="/album/album-search",method=RequestMethod.POST)
	public String searchResult(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="5")Integer limit,String keyword){
		PageInfo<Album> info = albumService.searchResult(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "album/album-search";
	}
}
