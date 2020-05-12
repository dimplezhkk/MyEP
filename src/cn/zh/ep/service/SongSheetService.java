
package cn.zh.ep.service;


import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Songsheet;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��11�� ����10:15:36 

* ˵�� ��

*/

public interface SongSheetService {

	/**
	 * ���Ӹ赥
	 * @param songsheet
	 */
	void addSongSheet(Songsheet songsheet);

	/**
	 * ��ѯ�赥����չʾ
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Songsheet> showSongSheetList(Integer page, Integer limit);

	/**
	 * ͨ��id��ѯ�赥��Ϣ
	 * @param songSheetId
	 * @return
	 */
	Songsheet selectSongSheetById(String songSheetId);

	/**
	 * ͨ��id�޸ĸ赥
	 * @param songSheet
	 */
	void editSongSheetById(Songsheet songSheet);

	/**
	 * ͨ��idɾ���赥��Ϣ
	 * @param songSheetId
	 */
	void delSongSheetById(String songSheetId);

	/**
	 * ͨ�������˲�ѯ�����赥
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Songsheet> searchResult(Integer page, Integer limit, String keyword);

	/**
	 * ��ѯ�赥��
	 * @return
	 */
	Integer count();

	

}
