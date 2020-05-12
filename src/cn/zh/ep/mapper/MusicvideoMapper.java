package cn.zh.ep.mapper;

import cn.zh.ep.pojo.Musicvideo;
import cn.zh.ep.pojo.MusicvideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicvideoMapper {
    int countByExample(MusicvideoExample example);

    int deleteByExample(MusicvideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Musicvideo record);

    int insertSelective(Musicvideo record);

    List<Musicvideo> selectByExample(MusicvideoExample example);

    Musicvideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Musicvideo record, @Param("example") MusicvideoExample example);

    int updateByExample(@Param("record") Musicvideo record, @Param("example") MusicvideoExample example);

    int updateByPrimaryKeySelective(Musicvideo record);

    int updateByPrimaryKey(Musicvideo record);

    /**
     * 通过关键字（MV名称或者MV歌手名）查询MV
     * @param keyword
     * @return
     */
	List<Musicvideo> searchResult(String keyword);
}