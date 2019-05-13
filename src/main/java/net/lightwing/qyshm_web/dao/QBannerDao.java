package net.lightwing.qyshm_web.dao;

import java.util.List;
import net.lightwing.qyshm_web.pojo.QBanner;
import net.lightwing.qyshm_web.pojo.QBannerExample;
import org.apache.ibatis.annotations.Param;

public interface QBannerDao {
    long countByExample(QBannerExample example);

    int deleteByExample(QBannerExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(QBanner record);

    int insertSelective(QBanner record);

    List<QBanner> selectByExample(QBannerExample example);

    QBanner selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") QBanner record, @Param("example") QBannerExample example);

    int updateByExample(@Param("record") QBanner record, @Param("example") QBannerExample example);

    int updateByPrimaryKeySelective(QBanner record);

    int updateByPrimaryKey(QBanner record);
}