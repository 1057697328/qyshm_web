package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QQrcode;
import net.lightwing.qyshm_web.pojo.QQrcodeExample;
import org.apache.ibatis.annotations.Param;

public interface QQrcodeDao {
    long countByExample(QQrcodeExample example);

    int deleteByExample(QQrcodeExample example);

    int deleteByPrimaryKey(Integer qid);

    int insert(QQrcode record);

    int insertSelective(QQrcode record);

    List<QQrcode> selectByExample(QQrcodeExample example);

    QQrcode selectByPrimaryKey(Integer qid);

    int updateByExampleSelective(@Param("record") QQrcode record, @Param("example") QQrcodeExample example);

    int updateByExample(@Param("record") QQrcode record, @Param("example") QQrcodeExample example);

    int updateByPrimaryKeySelective(QQrcode record);

    int updateByPrimaryKey(QQrcode record);
}