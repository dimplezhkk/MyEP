
package cn.zh.ep.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zh.ep.pojo.Comment;
import cn.zh.ep.pojo.Score;
import cn.zh.ep.service.CommentServer;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��3��4�� ����6:06:34 

* ˵�� ��

*/
@Controller
public class CommentController {
	
	@Autowired
	private CommentServer commentServer;
	
	@RequestMapping(value="/comment/addComment",method=RequestMethod.POST)
	public void addComment(HttpServletRequest request){
		Comment comment = new Comment();
		Score score = new Score();
		
		comment.setMusicid(Integer.parseInt(request.getParameter("musicId")));
		comment.setUsername(request.getParameter("username"));
		comment.setContent(request.getParameter("comment"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//�������ڸ�ʽ
		comment.setTime(df.format(new Date()));
		comment.setImage(request.getParameter("image"));
		commentServer.addComment(comment);
		Integer musicId = Integer.parseInt(request.getParameter("musicId"));
		Integer scores = Integer.parseInt(request.getParameter("scores"));
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer countScore = commentServer.countByUserIdAndMusicId(userId,musicId);
		if (countScore > 0) {
			score.setMusicid(musicId);
			score.setUserid(userId);
			score.setScores(scores);
			commentServer.updateScore(score);
		}else {
			score.setMusicid(musicId);
			score.setScores(scores);
			score.setUserid(userId);
			commentServer.addScore(score);
		}
	}
}
