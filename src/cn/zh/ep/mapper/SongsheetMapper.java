package cn.zh.ep.mapper;

import cn.zh.ep.pojo.Songsheet;
import cn.zh.ep.pojo.SongsheetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SongsheetMapper {
    int countByExample(SongsheetExample example);

    int deleteByExample(SongsheetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Songsheet record);

    int insertSelective(Songsheet record);

    List<Songsheet> selectByExample(SongsheetExample example);

    Songsheet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Songsheet record, @Param("example") SongsheetExample example);

    int updateByExample(@Param("record") Songsheet record, @Param("example") SongsheetExample example);

    int updateByPrimaryKeySelective(Songsheet record);

    int updateByPrimaryKey(Songsheet record);
}