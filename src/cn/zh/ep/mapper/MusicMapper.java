package cn.zh.ep.mapper;

import cn.zh.ep.pojo.Music;
import cn.zh.ep.pojo.MusicExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicMapper {
    int countByExample(MusicExample example);

    int deleteByExample(MusicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Music record);

    int insertSelective(Music record);

    List<Music> selectByExample(MusicExample example);

    Music selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByExample(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
    
    List<Music> searchList(String keyword);

	ArrayList selectMusicListToSelect();

	int updataSongSheetId(@Param("songSheetId")Integer songSheetId, @Param("id")Integer id);

	void addMusicLyric(@Param("lyric")String lyric, @Param("id")Integer id);
}