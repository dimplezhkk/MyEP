
package cn.zh.ep.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Consumer;
import cn.zh.ep.service.HomeConsumerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月21日 下午7:26:33 

* 说明 ：

*/
@Controller
public class ConsumerController{

	@Autowired
	private HomeConsumerService homeConsumerService;
	
	@RequestMapping(value="/consumer/consumer-list")
	public String showConsumerPage(Model model,
			@RequestParam(required = false, defaultValue = "8")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page){
		PageInfo<Consumer> info = homeConsumerService.selectConsumerList(page,limit);
		model.addAttribute("pageInfo", info);
		return "/consumer/consumer-list";
	}
	
	@RequestMapping(value="/consumer/consumer-add")
	public String showAddConsumerPage(){
		
		return "consumer/consumer-add";
	}
	
	@RequestMapping(value="/consumer/addConsumer",method=RequestMethod.POST)
	public void addConsumer(Consumer consumer){
		homeConsumerService.register(consumer);
	}
	
	@RequestMapping(value="/consumer/consumer-edit")
	public String showEditConsumerPage(Model model,String consumerId){
		Consumer consumer = homeConsumerService.selectConsumerById(consumerId);
		model.addAttribute("consumer", consumer);
		return "/consumer/consumer-edit";
	}
	
	@RequestMapping(value="/consumer/editConsumer",method=RequestMethod.POST)
	public void EditConsumer(Consumer consumer){
		homeConsumerService.updateConsumer(consumer);
	}
	
	@RequestMapping(value="/consumer/editPassword")
	public String showEdutPasswordPage(Model model,String consumerId){
			Consumer consumer = homeConsumerService.selectConsumerById(consumerId);
			model.addAttribute("consumer", consumer);
		return "/consumer/edit-password";
		
	}
	
	@RequestMapping(value="/consumer/editPassword",method=RequestMethod.POST)
	public void editPassword(String id,String password){
		homeConsumerService.updatePassword(id, password);
	}
	
	@RequestMapping(value="/consumer/consumer-del",method=RequestMethod.POST)
	@ResponseBody
	public void delConsumer(String consumerId){
		homeConsumerService.delConsumerById(consumerId);	
	}
	
	@RequestMapping(value="/consumer/consumer-search",method=RequestMethod.POST)
	public String searchConsumer(Model model,
			@RequestParam(required = false, defaultValue = "8")Integer limit,
			@RequestParam(required = false, defaultValue = "1")Integer page,String keyword){
		
		PageInfo<Consumer> info = homeConsumerService.selectConsumerListByUsername(page,limit,keyword);
		model.addAttribute("pageInfo", info);
		return "/consumer/consumer-search";
	}
}
