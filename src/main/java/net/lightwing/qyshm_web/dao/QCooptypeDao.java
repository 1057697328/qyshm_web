package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QCooptype;
import net.lightwing.qyshm_web.pojo.QCooptypeExample;
import org.apache.ibatis.annotations.Param;

public interface QCooptypeDao {
    long countByExample(QCooptypeExample example);

    int deleteByExample(QCooptypeExample example);

    int deleteByPrimaryKey(Integer ctypeid);

    int insert(QCooptype record);

    int insertSelective(QCooptype record);

    List<QCooptype> selectByExample(QCooptypeExample example);

    QCooptype selectByPrimaryKey(Integer ctypeid);

    int updateByExampleSelective(@Param("record") QCooptype record, @Param("example") QCooptypeExample example);

    int updateByExample(@Param("record") QCooptype record, @Param("example") QCooptypeExample example);

    int updateByPrimaryKeySelective(QCooptype record);

    int updateByPrimaryKey(QCooptype record);
}