
package cn.zh.ep.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import cn.zh.ep.pojo.Musicvideo;
import cn.zh.ep.service.HomeMusicVideoService;
import cn.zh.ep.service.MusicVideoService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月16日 下午2:39:55 

* 说明 ：

*/
@Controller
public class HomeMusicVideoController {

	@Autowired
	private HomeMusicVideoService homeMusicVideoService;
	@Autowired
	private MusicVideoService musicVideoService;
	@RequestMapping(value="/musicVideo")
	public String showMusicVideoPage(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="8")Integer limit){
		PageInfo<Musicvideo> info = homeMusicVideoService.selectThreeNewMusicVideo(page,limit);
		PageInfo<Musicvideo> MusicVideoinfo = homeMusicVideoService.selectMusicVideoList(page,limit);
		model.addAttribute("pageInfo", info);
		model.addAttribute("MusicVideoinfo", MusicVideoinfo);
		return "mv/mv";
	}
	
	@RequestMapping(value="/home/showMusicVideoInfo")
	public String showMusicVideoInfo(Model model,String mvId){
		Musicvideo musicvideo = musicVideoService.selectMusicVideoById(mvId);
		String singer = musicvideo.getSinger();
		List<Musicvideo> musicvideos = homeMusicVideoService.selectMusicVideoBySingerName(singer);
		model.addAttribute("mv", musicvideo);
		model.addAttribute("list", musicvideos);
		return "mv/mv-detail";
	}
	
}
