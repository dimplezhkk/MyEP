
package cn.zh.ep.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.zh.ep.pojo.Music;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��2��5�� ����7:20:30 

* ˵�� ��

*/

public interface MusicService {
	/**
	 * ����������Ϣ
	 */
	void addMusic(Music music);
	/**
	 * չʾ��������
	 * @return
	 */
	List<Music> showMusicList();
	PageInfo<Music> showMusicListByPage(Integer page, Integer limit);
	/**
	 * ɾ��������Ϣ
	 * @param musicId
	 */
	void delMusicById(String musicId);
	
	/**
	 * ͨ������id��ѯ������Ϣ
	 * @param musicId
	 * @return
	 */
	Music selectMusicById(String musicId);
	/**
	 * һ������id�޸�������Ϣ
	 * @param music
	 * @param musicId
	 */
	void editMusic(Music music);
	/**
	 * ������ѯ������Ϣ����ҳ
	 * @param limit 
	 * @param page 
	 * @param search
	 * @return
	 */
	PageInfo<Music> searchMusic(Integer page, Integer limit, String keyword);
	/**
	 * ��ѯ�������Ʒ���select��
	 * @return
	 */
	ArrayList selectMusicListToSelect();
	
	/**
	 * ͨ�����ָ���id�޸����ָ����ĸ赥id
	 * @param musicId
	 * @param id
	 */
	void updataSongSheetId(String songSheetId, String id);
	
	/**
	 * ��ѯ���µ�8������
	 * @return
	 */
	PageInfo<Music> showNewMusicList();
	/**
	 * ��ѯ���а�5������
	 * @return
	 */
	PageInfo<Music> selectRankList();
	/**
	 * ���Ӹ�ʵ�ַ
	 * @param lyricFile
	 * @param id
	 */
	void updateMusicLyric(String lyricFile, String id);
	/**
	 * ��ѯ��ҥ��������
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showBallad(Integer page, Integer limit);
	/**
	 * ��ѯ���з���
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showPopular(Integer page, Integer limit);
	/**
	 * ��ѯ�����ַ���
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showAbsolute(Integer page, Integer limit);
	/**
	 * ��ѯ��³˹����
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showBlues(Integer page, Integer limit);
	/**
	 * ��ѯ�ŵ����ַ���
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showClassical(Integer page, Integer limit);
	/**
	 * ��ѯ��������
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Music> showHiphop(Integer page, Integer limit);
	/**
	 * ���ݸ��ֲ�ѯ�����б�
	 * @param musicSinger
	 * @return
	 */
	List<Music> showMusicListBySingerName(String musicSinger);
	/**
	 * ���ݸ���������ѯ������Ϣ
	 * @param musicSinger
	 * @return
	 */
	Music showMusicBySingerName(String musicSinger);
	/**
	 * ����ר��id��ѯ����ר��������
	 * @param albumId
	 * @return
	 */
	List<Music> selectMusicListByAlbumId(String albumId);
	/**
	 * ��ѯ������
	 * @return
	 */
	Integer count();
	/**
	 * ͨ���������ƻ�ȡ������Ϣ
	 * @param musicName
	 * @return
	 */
	Music selectMusicByMusicName(String musicName);
	/**
	 * ͨ������id��ѯ������Ϣ
	 * @param musicid
	 * @return 
	 */
	Music selectMusicById(Integer musicid);
}
