
package cn.zh.ep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zh.ep.pojo.Rotation;
import cn.zh.ep.service.AlbumService;
import cn.zh.ep.service.HomeConsumerService;
import cn.zh.ep.service.MusicService;
import cn.zh.ep.service.MusicVideoService;
import cn.zh.ep.service.RotationService;
import cn.zh.ep.service.SingerService;
import cn.zh.ep.service.SongSheetService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月3日 下午10:26:19 

* 说明 ：

*/
@Controller
public class IndexController {
	
	@Autowired
	private MusicService musicService;
	@Autowired
	private MusicVideoService musicVideoService;
	@Autowired
	private SingerService singerService;
	@Autowired
	private SongSheetService songSheetService;
	@Autowired
	private HomeConsumerService homeConsumerService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private RotationService rotationService;
	@RequestMapping("/user/welcome")
	public String welcome(Model model){
		Integer music = musicService.count();
		Integer mv = musicVideoService.count();
		Integer album = albumService.count();
		Integer singer = singerService.count();
		Integer songSheet = songSheetService.count();
		Integer consumer = homeConsumerService.count();
		model.addAttribute("music", music);
		model.addAttribute("mv", mv);
		model.addAttribute("album", album);
		model.addAttribute("singer", singer);
		model.addAttribute("songSheet", songSheet);
		model.addAttribute("consumer", consumer);
		return "welcome";
	}
	
	@RequestMapping(value="/welcome")
	public String showWelcome(Model model){
		List<Rotation> list = rotationService.selectRotationList();
		model.addAttribute("list", list);
		return "home/welcome";
	}
}
