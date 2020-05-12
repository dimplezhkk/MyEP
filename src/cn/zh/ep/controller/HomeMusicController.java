
package cn.zh.ep.controller;



import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import cn.zh.ep.pojo.Comment;
import cn.zh.ep.pojo.Consumer;
import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.Recommend;
import cn.zh.ep.pojo.SingerWithBLOBs;
import cn.zh.ep.service.CommentServer;
import cn.zh.ep.service.MusicService;
import cn.zh.ep.service.SingerService;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年2月14日 下午5:01:11 

* 说明 ：

*/
@Controller
public class HomeMusicController {
	
	@Autowired
	private MusicService musicService;
	@Autowired
	private SingerService singerService;
	@Autowired
	private CommentServer commentServer;
	
	@RequestMapping(value="/music")
	public String showMusicList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
			PageInfo<Music> info = musicService.showMusicListByPage(page, limit);
			model.addAttribute("pageInfo", info);
		return "home/music";
	}
	
	@RequestMapping(value="/ballad")
	public String showBalladList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showBallad(page,limit);
		model.addAttribute("pageInfo", info);
		return "home/ballad";
	}

	@RequestMapping(value="/popular")
	public String showPopularList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showPopular(page,limit);
		model.addAttribute("pageInfo", info);
		return "home/popular";
		
	}
	
	@RequestMapping(value="/absolute")
	public String showAbsoluteList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showAbsolute(page,limit);
		model.addAttribute("pageInfo", info);
		return "home/absolute";
		
	}
	
	@RequestMapping(value="/blues")
	public String showBluesList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showBlues(page,limit);
		model.addAttribute("pageInfo", info);
		return "home/blues";
		
	}
	
	@RequestMapping(value="/classical")
	public String showClassicalList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showClassical(page,limit);
		model.addAttribute("pageInfo", info);
		return "home/classical";
		
	}
	
	@RequestMapping(value="/hiphop")
	public String showHiphopList(Model model,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="12")Integer limit){
		PageInfo<Music> info = musicService.showHiphop(page,limit);
		model.addAttribute("pageInfo", info);
		return "home/hiphop";
		
	}
	
	@RequestMapping(value="/home/showMusicInfo")
	public String showSingerInfo(Model model,String musicSinger,String musicName,
			@RequestParam(required=false,defaultValue="1")Integer page,
			@RequestParam(required=false,defaultValue="50")Integer limit,
			HttpSession session){
		Consumer consumer = (Consumer) session.getAttribute("consumer");
		if (consumer != null) {
			List<Recommend> recommendList = commentServer.selectRecommendByConsumerId(consumer.getId());
			List<Music> rlist = new ArrayList<Music>();
			for (Recommend recommend : recommendList) {
				if (recommend.getRating() != 0) {
					Music music = musicService.selectMusicById(recommend.getMusicid());
					rlist.add(music);
				}
			}
			model.addAttribute("rlist", rlist);
		}
		try {
			SingerWithBLOBs singer = singerService.selectSingerBySingerName(musicSinger);
			List<Music> list = musicService.showMusicListBySingerName(musicSinger);
			Music music = musicService.showMusicBySingerName(musicSinger);
			Music musicinfo = musicService.selectMusicByMusicName(musicName);
			PageInfo<Comment> info = commentServer.showCommentByMUsicId(musicinfo.getId(),page,limit);
			 model.addAttribute("singer",singer);
			 model.addAttribute("list", list);
			 model.addAttribute("music", music);
			 model.addAttribute("musicinfo", musicinfo);
			 model.addAttribute("pageInfo",info);
		} catch (Exception e) {
			return "home/error";
		}
		return "home/singer-detail";
	}
}
