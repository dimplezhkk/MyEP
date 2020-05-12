package cn.zh.ep.mapper;

import cn.zh.ep.pojo.Singer;
import cn.zh.ep.pojo.SingerExample;
import cn.zh.ep.pojo.SingerWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingerMapper {
    int countByExample(SingerExample example);

    int deleteByExample(SingerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SingerWithBLOBs record);

    int insertSelective(SingerWithBLOBs record);

    List<SingerWithBLOBs> selectByExampleWithBLOBs(SingerExample example);

    List<Singer> selectByExample(SingerExample example);

    SingerWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SingerWithBLOBs record, @Param("example") SingerExample example);

    int updateByExampleWithBLOBs(@Param("record") SingerWithBLOBs record, @Param("example") SingerExample example);

    int updateByExample(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByPrimaryKeySelective(SingerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SingerWithBLOBs record);

    int updateByPrimaryKey(Singer record);
}