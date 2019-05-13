package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QConfig;
import net.lightwing.qyshm_web.pojo.QConfigExample;
import org.apache.ibatis.annotations.Param;

public interface QConfigDao {
    long countByExample(QConfigExample example);

    int deleteByExample(QConfigExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(QConfig record);

    int insertSelective(QConfig record);

    List<QConfig> selectByExample(QConfigExample example);

    QConfig selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") QConfig record, @Param("example") QConfigExample example);

    int updateByExample(@Param("record") QConfig record, @Param("example") QConfigExample example);

    int updateByPrimaryKeySelective(QConfig record);

    int updateByPrimaryKey(QConfig record);
}