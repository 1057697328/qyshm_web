package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QNews;
import net.lightwing.qyshm_web.pojo.QNewsExample;
import org.apache.ibatis.annotations.Param;

public interface QNewsDao {
    long countByExample(QNewsExample example);

    int deleteByExample(QNewsExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(QNews record);

    int insertSelective(QNews record);

    List<QNews> selectByExampleWithBLOBs(QNewsExample example);

    List<QNews> selectByExample(QNewsExample example);

    QNews selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") QNews record, @Param("example") QNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") QNews record, @Param("example") QNewsExample example);

    int updateByExample(@Param("record") QNews record, @Param("example") QNewsExample example);

    int updateByPrimaryKeySelective(QNews record);

    int updateByPrimaryKeyWithBLOBs(QNews record);

    int updateByPrimaryKey(QNews record);
}