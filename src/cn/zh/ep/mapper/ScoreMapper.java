package cn.zh.ep.mapper;

import cn.zh.ep.pojo.Score;
import cn.zh.ep.pojo.ScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    int countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

	int updateByUserIdAndMusicId(Score score);

	int selectByUserIdAndMusicId(@Param("userId")Integer userId, @Param("musicId")Integer musicId);
}