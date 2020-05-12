
package cn.zh.ep.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.User;
import cn.zh.ep.service.UserService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月2日 下午1:13:42 

* 说明 ：

*/
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String login(String username,String password,RedirectAttributes attr,HttpServletRequest request){
		User userLogin = userService.userLogin(username, password);
		if (userLogin == null) {
			attr.addFlashAttribute("error_mess", "登录账号或密码错误");
			return "redirect:/user/login";
		}
		request.getSession().setAttribute("user", userLogin);
		return "redirect:/user/index";
	}
	
	@RequestMapping("/user/quit")
	public String quit(HttpSession session){
		session.setAttribute("user", null);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/admin/user-list")
	public String showAdminPage(Model model,
			@RequestParam(required=false,defaultValue="8")Integer limit,
			@RequestParam(required=false,defaultValue="1")Integer page){
		PageInfo<User> info = userService.selectUserList(page,limit);
		model.addAttribute("pageInfo", info);
		return "/admin/user-list";
	}
	
	@RequestMapping(value="/admin/user-add")
	public String showAddUserPage(){
		
		return "/admin/user-add";
	}
	
	@RequestMapping(value="/admin/checkUsername")
	@ResponseBody
	public void checkUsername(HttpServletResponse response,String username) throws Exception{
		boolean isExist = false;
        try {
            isExist = userService.checkUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("{\"isExist\":"+isExist+"}");
	}
	
	@RequestMapping(value="/admin/addUser",method=RequestMethod.POST)
	public void addUser(User user){
		userService.insertUser(user);
	}
	
	@RequestMapping(value="/admin/user-edit")
	public String showEditUserPage(Model model,String userId){
		User user =  userService.selectUserById(userId);
		model.addAttribute("user", user);
		return "/admin/user-edit";
	}
	
	@RequestMapping(value="/admin/editUser",method=RequestMethod.POST)
	public void editUser(User user){
		userService.editUser(user);
	}
	
	@RequestMapping(value="/admin/editPassword")
	public String showEditPasswordPage(Model model,String userId){
		User user = userService.selectUserById(userId);
		model.addAttribute("user", user);
		return "/admin/edit-password";
	}
	
	@RequestMapping(value="/admin/editPassword",method=RequestMethod.POST)
	public void editUserPassword(String id,String password) {
		userService.updateUserPassword(id,password);
	}
	
	@RequestMapping(value="/admin/user-del",method=RequestMethod.POST)
	@ResponseBody
	public void delUser(String userId){
		userService.delUserById(userId);
	}
	
	@RequestMapping(value="/admin/user-search")
	public String searchUser(Model model,
			@RequestParam(required = false, defaultValue = "8")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page,String keyword){
		PageInfo<User> info = userService.searchUser(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "/admin/user-search";
	}
}
