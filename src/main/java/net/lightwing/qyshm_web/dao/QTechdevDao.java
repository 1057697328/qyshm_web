package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QTechdev;
import net.lightwing.qyshm_web.pojo.QTechdevExample;
import org.apache.ibatis.annotations.Param;

public interface QTechdevDao {
    long countByExample(QTechdevExample example);

    int deleteByExample(QTechdevExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(QTechdev record);

    int insertSelective(QTechdev record);

    List<QTechdev> selectByExampleWithBLOBs(QTechdevExample example);

    List<QTechdev> selectByExample(QTechdevExample example);

    QTechdev selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") QTechdev record, @Param("example") QTechdevExample example);

    int updateByExampleWithBLOBs(@Param("record") QTechdev record, @Param("example") QTechdevExample example);

    int updateByExample(@Param("record") QTechdev record, @Param("example") QTechdevExample example);

    int updateByPrimaryKeySelective(QTechdev record);

    int updateByPrimaryKeyWithBLOBs(QTechdev record);

    int updateByPrimaryKey(QTechdev record);
}