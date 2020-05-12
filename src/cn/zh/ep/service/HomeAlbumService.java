
package cn.zh.ep.service;

import java.util.List;

import cn.zh.ep.pojo.Album;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��15�� ����7:03:37 

* ˵�� ��

*/

public interface HomeAlbumService {

	/**
	 * ��ѯ���е�ר��
	 * @return
	 */
	List<Album> showAlbumList();

	/**
	 * ����ר��id��ѯר����Ϣ
	 * @param albumId
	 * @return
	 */
	Album selectAlbumInfo(String albumId);

	/**
	 * ��ѯר�������ʾ����
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Album> showAlbumList(Integer page, Integer limit);

}
