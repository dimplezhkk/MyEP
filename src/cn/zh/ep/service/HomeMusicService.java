
package cn.zh.ep.service;

import java.util.List;

import cn.zh.ep.pojo.Music;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��15�� ����11:07:07 

* ˵�� ��

*/

public interface HomeMusicService {

	/**
	 * ͨ���赥id��ѯ�赥����
	 * @param id
	 * @return
	 */
	List<Music> selectMusicListBySongSheetId(Integer id);

}
