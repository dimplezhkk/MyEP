
package cn.zh.ep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月1日 下午9:21:07 

* 说明 ：页面展示

*/

@Controller
public class PageController {
	
	@RequestMapping("/user/login")
	public String loginAndRegister(){
		return "login";
	}
	@RequestMapping("/user/index")
	public String showIndex(){
		return "index";
	}
}
