
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
import cn.zh.ep.pojo.Rotation;
import cn.zh.ep.service.RotationService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月17日 上午11:42:31 

* 说明 ：

*/
@Controller
public class RotationController {
	
	@Autowired
	private RotationService rotationService;

	
	@RequestMapping(value = "/rotation/rotation-list")
	public String showRotationList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="5")Integer limit){
		PageInfo<Rotation> info = rotationService.selectRotationList(page,limit);
		model.addAttribute("pageInfo", info);
		return "/rotation/rotation-list";
	}
	
	@RequestMapping(value="/rotation/rotation-add")
	public String addRotation(){
		
		return "/rotation/rotation-add";
	}
	
	@RequestMapping(value="/rotation/addRotation",method=RequestMethod.POST)
	public void addRotation(@RequestParam("url") MultipartFile file)throws Exception{
		Rotation rotation = new Rotation();
		String filename = file.getOriginalFilename();
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+filename),true);
		rotation.setImage("audio/" + filename);
		rotationService.addRotation(rotation);
	}
	
	@RequestMapping(value="/rotation/rotation-edit")
	public String showEditRotationPage(Model model,String rotationId){
		 Rotation rotation  = rotationService.selectRotationById(rotationId);
		 Integer id = rotation.getId();
		 model.addAttribute("id", id);
		return "/rotation/rotation-edit";
	}
	
	@RequestMapping(value="/rotation/editRotation",method=RequestMethod.POST)
	public void editRotation(HttpServletRequest request,@RequestParam("url") MultipartFile file)throws Exception{
		Rotation rotation = new Rotation();
		rotation.setId(Integer.parseInt(request.getParameter("id")));
		String filename = file.getOriginalFilename();
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\audio\\"+filename),true);
		rotation.setImage("audio/" + filename);
		rotationService.editRotation(rotation);
	}
	
	@RequestMapping(value="/rotation/rotation-del",method=RequestMethod.POST)
	@ResponseBody
	public void delRotation(String rotationId){
		rotationService.delRotationById(rotationId);
	}
}
