
package cn.zh.ep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��1�� ����9:21:07 

* ˵�� ��ҳ��չʾ

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
