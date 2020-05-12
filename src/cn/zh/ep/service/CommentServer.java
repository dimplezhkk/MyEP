
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Comment;
import cn.zh.ep.pojo.Recommend;
import cn.zh.ep.pojo.Score;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��3��4�� ����8:17:11 

* ˵�� ��

*/

public interface CommentServer {

	/**
	 * ��������
	 * @param comment
	 */
	void addComment(Comment comment);

	/**
	 * ��������
	 * @param score
	 */
	void addScore(Score score);

	/**
	 * ͨ������id��ѯ���۽�����ʾ
	 * @param id
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Comment> showCommentByMUsicId(Integer id, Integer page, Integer limit);

	void updateScore(Score score);

	/**
	 * ͨ���û�id�����id��ѯ�����Ƿ����
	 * @param userId
	 * @param musicId
	 * @return
	 */
	Integer countByUserIdAndMusicId(Integer userId, Integer musicId);

	/**
	 * ͨ���û�id��ѯ�Ƽ�����id
	 * @param id
	 * @return
	 */
	List<Recommend> selectRecommendByConsumerId(Integer id);

}
