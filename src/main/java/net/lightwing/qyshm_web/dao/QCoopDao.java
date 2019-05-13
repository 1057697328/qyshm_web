package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QCoop;
import net.lightwing.qyshm_web.pojo.QCoopExample;
import org.apache.ibatis.annotations.Param;

public interface QCoopDao {
    long countByExample(QCoopExample example);

    int deleteByExample(QCoopExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(QCoop record);

    int insertSelective(QCoop record);

    List<QCoop> selectByExample(QCoopExample example);

    QCoop selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") QCoop record, @Param("example") QCoopExample example);

    int updateByExample(@Param("record") QCoop record, @Param("example") QCoopExample example);

    int updateByPrimaryKeySelective(QCoop record);

    int updateByPrimaryKey(QCoop record);
}