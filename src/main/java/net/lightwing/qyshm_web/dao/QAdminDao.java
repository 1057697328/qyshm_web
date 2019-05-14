package net.lightwing.qyshm_web.dao;

import java.util.List;

import net.lightwing.qyshm_web.pojo.QAdmin;
import net.lightwing.qyshm_web.pojo.QAdminExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QAdminDao {
    long countByExample(QAdminExample example);

    int deleteByExample(QAdminExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(QAdmin record);

    int insertSelective(QAdmin record);

    List<QAdmin> selectByExample(QAdminExample example);

    QAdmin selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") QAdmin record, @Param("example") QAdminExample example);

    int updateByExample(@Param("record") QAdmin record, @Param("example") QAdminExample example);

    int updateByPrimaryKeySelective(QAdmin record);

    int updateByPrimaryKey(QAdmin record);
}