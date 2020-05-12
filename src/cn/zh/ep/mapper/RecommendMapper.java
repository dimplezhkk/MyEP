package cn.zh.ep.mapper;

import cn.zh.ep.pojo.Recommend;
import cn.zh.ep.pojo.RecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    int countByExample(RecommendExample example);

    int deleteByExample(RecommendExample example);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendExample example);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);
}