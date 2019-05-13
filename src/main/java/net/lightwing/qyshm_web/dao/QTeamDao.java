package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.pojo.QTeamExample;
import org.apache.ibatis.annotations.Param;

public interface QTeamDao {
    long countByExample(QTeamExample example);

    int deleteByExample(QTeamExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(QTeam record);

    int insertSelective(QTeam record);

    List<QTeam> selectByExampleWithBLOBs(QTeamExample example);

    List<QTeam> selectByExample(QTeamExample example);

    QTeam selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") QTeam record, @Param("example") QTeamExample example);

    int updateByExampleWithBLOBs(@Param("record") QTeam record, @Param("example") QTeamExample example);

    int updateByExample(@Param("record") QTeam record, @Param("example") QTeamExample example);

    int updateByPrimaryKeySelective(QTeam record);

    int updateByPrimaryKeyWithBLOBs(QTeam record);

    int updateByPrimaryKey(QTeam record);
}