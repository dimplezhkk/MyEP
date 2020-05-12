
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Comment;
import cn.zh.ep.pojo.Recommend;
import cn.zh.ep.pojo.Score;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年3月4日 下午8:17:11 

* 说明 ：

*/

public interface CommentServer {

	/**
	 * 增加评论
	 * @param comment
	 */
	void addComment(Comment comment);

	/**
	 * 增加评分
	 * @param score
	 */
	void addScore(Score score);

	/**
	 * 通过歌曲id查询评论进行显示
	 * @param id
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Comment> showCommentByMUsicId(Integer id, Integer page, Integer limit);

	void updateScore(Score score);

	/**
	 * 通过用户id与歌曲id查询评分是否存在
	 * @param userId
	 * @param musicId
	 * @return
	 */
	Integer countByUserIdAndMusicId(Integer userId, Integer musicId);

	/**
	 * 通过用户id查询推荐歌曲id
	 * @param id
	 * @return
	 */
	List<Recommend> selectRecommendByConsumerId(Integer id);

}
