package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QProduct;
import net.lightwing.qyshm_web.pojo.QProductExample;
import org.apache.ibatis.annotations.Param;

public interface QProductDao {
    long countByExample(QProductExample example);

    int deleteByExample(QProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(QProduct record);

    int insertSelective(QProduct record);

    List<QProduct> selectByExampleWithBLOBs(QProductExample example);

    List<QProduct> selectByExample(QProductExample example);

    QProduct selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") QProduct record, @Param("example") QProductExample example);

    int updateByExampleWithBLOBs(@Param("record") QProduct record, @Param("example") QProductExample example);

    int updateByExample(@Param("record") QProduct record, @Param("example") QProductExample example);

    int updateByPrimaryKeySelective(QProduct record);

    int updateByPrimaryKeyWithBLOBs(QProduct record);

    int updateByPrimaryKey(QProduct record);
}