
package cn.zh.ep.service;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Musicvideo;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��12�� ����10:22:02 

* ˵�� ��

*/

public interface MusicVideoService {

	/**
	 * ����mv��Ϣ
	 * @param mv
	 */
	void addMusicVideo(Musicvideo mv);

	/**
	 * ��ҳ��ѯMV��ʾ��ҳ��
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Musicvideo> selectMusicVideoList(Integer page, Integer limit);

	/**
	 * ͨ��MV��id��ѯMV����Ϣչʾ���޸�ҳ����
	 * @param mvId
	 * @return
	 */
	Musicvideo selectMusicVideoById(String mvId);
	
	/**
	 * ͨ��id�޸�MV����Ϣ
	 * @param mv
	 */
	void selectMusicVideoById(Musicvideo mv);

	/**
	 * ͨ��idɾ��MV��Ϣ
	 * @param mvId
	 */
	void delMusicVideoById(String mvId);

	/**
	 * ͨ���ؼ��֣�MV���ƻ���MV����������ѯMV
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Musicvideo> searchResult(Integer page, Integer limit, String keyword);

	/**
	 * ��ѯMV��
	 * @return
	 */
	Integer count();

}
