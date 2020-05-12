
package cn.zh.ep.service;

import java.util.List;

import cn.zh.ep.pojo.Songsheet;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��15�� ����10:59:25 

* ˵�� ��

*/

public interface HomeSongSheetService {

	/**
	 * ��ѯ���µĸ赥��ʾ
	 * @return
	 */
	Songsheet selectNewOneSongSheet();

	/**
	 * ��ѯ���и赥�б�
	 * @return
	 */
	List<Songsheet> selectSongSheetList();

	/**
	 * ����id��ѯ�赥��ʾ
	 * @param songSheetId
	 * @return
	 */
	Songsheet selectSongSheetBy(String songSheetId);

}
