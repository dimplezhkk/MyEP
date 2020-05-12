
package cn.zh.ep.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Musicvideo;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��16�� ����3:34:44 

* ˵�� ��

*/

public interface HomeMusicVideoService {

	/**
	 * ��ѯ���µ�����MV����
	 * @return
	 */
	PageInfo<Musicvideo> selectThreeNewMusicVideo(Integer page, Integer limit);
	
	/**
	 * ��ѯȫ��MV���з�ҳ
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Musicvideo> selectMusicVideoList(Integer page, Integer limit);

	/**
	 * ͨ������������ѯ����MV
	 * @param singer
	 * @return
	 */
	List<Musicvideo> selectMusicVideoBySingerName(String singer);

	

}
