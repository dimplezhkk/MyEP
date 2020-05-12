
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

import cn.zh.ep.pojo.SingerWithBLOBs;
import cn.zh.ep.service.SingerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月9日 下午10:03:11 

* 说明 ：

*/
@Controller
public class SingerController {
	@Autowired
	private SingerService singerService;

	@RequestMapping(value = "/music/singer-list",method=RequestMethod.GET)
	public String showSingerList(Model model,
			@RequestParam(required = false, defaultValue = "5")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page){
		PageInfo<SingerWithBLOBs> info = singerService.showSingerListByPage(page,limit);
		model.addAttribute("pageInfo", info);
		return "singer/singer-list";
	}
	
	@RequestMapping(value = "/music/singer-add")
	public String addSinger(){
		return "singer/singer-add";
	}
	
	@RequestMapping(value="/music/addSinger", method=RequestMethod.POST)
	public void singerAdd(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("url") MultipartFile file) throws Exception{
		SingerWithBLOBs singer = new SingerWithBLOBs();
		singer.setSinger(request.getParameter("singer"));
		singer.setSingertype(request.getParameter("singertype"));
		singer.setSex(request.getParameter("sex"));
		singer.setDescription(request.getParameter("description"));
		singer.setHot(request.getParameter("hot"));
		//上传文件
		/*ServletContext context = request.getServletContext();*/
		//获取保存文件的路径
		/*String path = context.getRealPath("images");*/
		//获取文件名
		String filename = file.getOriginalFilename();
		//保存文件
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\singer\\"+filename),true);
		singer.setImage("singer/" + filename);
		singerService.addSinger(singer);
	}
	
	@RequestMapping(value="/music/singer-edit")
	public String editSinger(String singerId,Model model){
		SingerWithBLOBs singer =  singerService.selectSingerById(singerId);
		model.addAttribute("singer", singer);
		return "singer/singer-edit";
	}
	
	@RequestMapping(value="/music/editSinger",method=RequestMethod.POST)
	public void editSinger(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("url") MultipartFile file) throws Exception{
		SingerWithBLOBs singer = new SingerWithBLOBs();
		singer.setId(Integer.parseInt(request.getParameter("id")));
		singer.setSinger(request.getParameter("singer"));
		singer.setSingertype(request.getParameter("singertype"));
		singer.setSex(request.getParameter("sex"));
		singer.setDescription(request.getParameter("description"));
		singer.setHot(request.getParameter("hot"));
		//上传文件
		/*ServletContext context = request.getServletContext();
		//获取保存文件的路径
		String path = context.getRealPath("images");*/
		//获取文件名
		String filename = file.getOriginalFilename();
		//保存文件
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\singer\\"+filename),true);
		singer.setImage("singer/" + filename);
		singerService.editSinger(singer);
	}
	
	@RequestMapping(value="/music/singer-del",method=RequestMethod.POST)
	@ResponseBody
	public void delSinger(String singerId){
		singerService.delSingerById(singerId);
	}
	@RequestMapping(value="/music/singer-search",method=RequestMethod.POST)
	public String searchResult(Model model,
			@RequestParam(required = false, defaultValue = "5")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page,String keyword){
		PageInfo<SingerWithBLOBs> info = singerService.searchSinger(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "singer/singer-search";
	}
}