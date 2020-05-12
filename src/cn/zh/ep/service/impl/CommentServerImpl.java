
package cn.zh.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zh.ep.mapper.CommentMapper;
import cn.zh.ep.mapper.RecommendMapper;
import cn.zh.ep.mapper.ScoreMapper;
import cn.zh.ep.pojo.Comment;
import cn.zh.ep.pojo.CommentExample;
import cn.zh.ep.pojo.CommentExample.Criteria;
import cn.zh.ep.pojo.Recommend;
import cn.zh.ep.pojo.RecommendExample;
import cn.zh.ep.pojo.Score;
import cn.zh.ep.service.CommentServer;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年3月4日 下午8:19:59 

* 说明 ：

*/
@Service
public class CommentServerImpl implements CommentServer {

	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private ScoreMapper scoreMapper;
	@Autowired
	private RecommendMapper recommendMapper;
	
	@Override
	public void addComment(Comment comment) {
		commentMapper.insert(comment);
	}
	
	@Override
	public void addScore(Score score) {
		scoreMapper.insert(score);
	}

	@Override
	public PageInfo<Comment> showCommentByMUsicId(Integer id, Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		CommentExample example = new CommentExample();
		example.setOrderByClause("id DESC");
		Criteria criteria = example.createCriteria();
		criteria.andMusicidEqualTo(id);
		List<Comment> list = commentMapper.selectByExample(example);
		PageInfo<Comment> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public void updateScore(Score score) {
		scoreMapper.updateByUserIdAndMusicId(score);
	}

	@Override
	public Integer countByUserIdAndMusicId(Integer userId, Integer musicId) {
		Integer count = scoreMapper.selectByUserIdAndMusicId(userId,musicId);
		return count;
	}

	@Override
	public List<Recommend> selectRecommendByConsumerId(Integer userId) {
		RecommendExample example = new RecommendExample();
		example.setOrderByClause("rating DESC");
		cn.zh.ep.pojo.RecommendExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<Recommend> list = recommendMapper.selectByExample(example);
		return list;
	}
}
