package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QTeamtype;
import net.lightwing.qyshm_web.pojo.QTeamtypeExample;
import org.apache.ibatis.annotations.Param;

public interface QTeamtypeDao {
    long countByExample(QTeamtypeExample example);

    int deleteByExample(QTeamtypeExample example);

    int deleteByPrimaryKey(Integer ttypeid);

    int insert(QTeamtype record);

    int insertSelective(QTeamtype record);

    List<QTeamtype> selectByExample(QTeamtypeExample example);

    QTeamtype selectByPrimaryKey(Integer ttypeid);

    int updateByExampleSelective(@Param("record") QTeamtype record, @Param("example") QTeamtypeExample example);

    int updateByExample(@Param("record") QTeamtype record, @Param("example") QTeamtypeExample example);

    int updateByPrimaryKeySelective(QTeamtype record);

    int updateByPrimaryKey(QTeamtype record);
}