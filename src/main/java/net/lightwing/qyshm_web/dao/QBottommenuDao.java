package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QBottommenu;
import net.lightwing.qyshm_web.pojo.QBottommenuExample;
import org.apache.ibatis.annotations.Param;

public interface QBottommenuDao {
    long countByExample(QBottommenuExample example);

    int deleteByExample(QBottommenuExample example);

    int deleteByPrimaryKey(Integer bmid);

    int insert(QBottommenu record);

    int insertSelective(QBottommenu record);

    List<QBottommenu> selectByExample(QBottommenuExample example);

    QBottommenu selectByPrimaryKey(Integer bmid);

    int updateByExampleSelective(@Param("record") QBottommenu record, @Param("example") QBottommenuExample example);

    int updateByExample(@Param("record") QBottommenu record, @Param("example") QBottommenuExample example);

    int updateByPrimaryKeySelective(QBottommenu record);

    int updateByPrimaryKey(QBottommenu record);
}