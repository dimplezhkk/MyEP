
package cn.zh.ep.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zh.ep.pojo.Consumer;
import cn.zh.ep.service.HomeConsumerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月19日 下午10:50:11 

* 说明 ：

*/
@Controller
public class HomeConsumerController {

	@Autowired
	private HomeConsumerService homeConsumerService;
	
	@RequestMapping(value="/publicy")
	public String showPublicy(){
		
		return "/home/publicy";
	}
	
	@RequestMapping(value="/home/sign-up")
	public String showSignUpPage(){
		return "/home/sign-up";
	}
	
	@RequestMapping(value="/home/sign-in")
	public String showSignInPage(){
		
		return "/home/sign-in";
	}
	
	@RequestMapping(value="/home/checkUsername")
	@ResponseBody
	public void checkUsername(HttpServletResponse response,String username) throws Exception{
		boolean isExist = false;
        try {
            isExist = homeConsumerService.checkUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"isExist\":"+isExist+"}");
	}
	
	@RequestMapping("/home/checkEmail")
	@ResponseBody
	public void checkData(HttpServletResponse response,String email) throws Exception{
		
		boolean emailExist = false;
        try {
            emailExist = homeConsumerService.checkEmail(email);  
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"emailExist\":"+emailExist+"}");
	}
	
	@RequestMapping(value="/home/register",method=RequestMethod.POST)
	public String register(Consumer consumer,RedirectAttributes attr){
		homeConsumerService.register(consumer);
		attr.addFlashAttribute("msg", "注册成功，来登录吧^_^");
		return "redirect:/home/sign-in";
	}
	
	@RequestMapping(value="/home/login",method=RequestMethod.POST)
	public String login(String username,String password,
			RedirectAttributes attr,HttpServletRequest request){
		Consumer consumer = homeConsumerService.consumerLogin(username, password);
		if (consumer == null) {
			attr.addFlashAttribute("error_mess", "登录账号或密码错误");
			return "redirect:/home/sign-in";
		}
		request.getSession().setAttribute("consumer", consumer);
		return "redirect:/welcome";
	}
	
	@RequestMapping(value="/home/quit")
	public String consumerQuit(HttpSession session){
		session.setAttribute("consumer", null);
		return "redirect:/welcome";
	}
	
	@RequestMapping(value="/home/setting")
	public String showSettingPage(Model model,String username){
		try {
			Consumer consumer = homeConsumerService.selectConsumerByUsername(username);
			model.addAttribute("consumer", consumer);
			return "/home/setting";
		} catch (Exception e) {
			return "/home/error";
		}
	}
	
	@RequestMapping(value="/home/setConsumer",method=RequestMethod.POST)
	@ResponseBody
	public void setConsumer(HttpServletRequest request,@RequestParam("url") MultipartFile file) throws Exception{
		Consumer consumer = new Consumer();
		consumer.setId(Integer.parseInt(request.getParameter("id")));
		consumer.setEmail(request.getParameter("email"));
		consumer.setNickname(request.getParameter("nickname"));
		consumer.setSex(request.getParameter("sex"));
		consumer.setUsername(request.getParameter("username"));
		consumer.setPassword(request.getParameter("password"));
		//获取文件名
		String filename = file.getOriginalFilename();
		//保存文件
		Streams.copy(file.getInputStream(), new FileOutputStream("E:\\upload\\singer\\"+filename),true);
		consumer.setImage("singer/" + filename);
		homeConsumerService.setConsumer(consumer);
		request.getSession().setAttribute("consumer", consumer);
		
	}	
	
	@RequestMapping(value="/home/setPassword")
	public String showSetPasswordPage(Model model,String username){
		try {
			Consumer consumer = homeConsumerService.selectConsumerByUsername(username);
			model.addAttribute("consumer", consumer);
			return "/home/set-password";
		} catch (Exception e) {
			return "/home/error";
		}
	}
	
	@RequestMapping(value="/home/editPassword",method=RequestMethod.POST)
	public String editPassword(Model model,String id,String password){
		homeConsumerService.updatePassword(id,password);
		model.addAttribute("msg", "密码修改成功");
		return "/home/set-password";
	}
}
