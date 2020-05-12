
package cn.zh.ep.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Album;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��10�� ����10:48:01 

* ˵�� ��

*/

public interface AlbumService {

	/**
	 * ����ר����Ϣ
	 * @param album
	 */
	void addAlbum(Album album);

	/**
	 * ��ҳչʾר����Ϣ
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Album> showAlbumListByPage(Integer page, Integer limit);

	/**
	 * ����ר��id����ר����Ϣ
	 * @param albumId
	 * @return
	 */
	Album editAlbum(String albumId);
	/**
	 * ͨ��id����ר�����޸�ר����Ϣ
	 * @param album
	 */
	void editAlbumById(Album album);

	/**
	 * ͨ��idɾ��ר����Ϣ
	 * @param albumId
	 */
	void delAlbum(String albumId);

	/**
	 * ���ݹؼ���ģ������ר����Ϣ���ؼ���Ϊ����������ר������
	 * @param page
	 * @param limit
	 * @param keyword
	 * @return
	 */
	PageInfo<Album> searchResult(Integer page, Integer limit, String keyword);

	ArrayList selectAlbumListToSelect();

	/**
	 * ͨ������������ѯ����ר��
	 * @param singer
	 * @return
	 */
	List<Album> showAlbumListBySingerName(String singer);

	/**
	 * ��ѯר����
	 * @return
	 */
	Integer count();

}
