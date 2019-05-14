package net.lightwing.qyshm_web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.pojo.QBanner;
import net.lightwing.qyshm_web.pojo.QBannerExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface QBannerDao extends BaseMapper<QBanner> {
    long countByExample(QBannerExample example);

    int deleteByExample(QBannerExample example);

    int deleteByPrimaryKey(Integer bid);

    Integer insert(QBanner record);

    int insertSelective(QBanner record);

    List<QBanner> selectByExample(QBannerExample example);

    QBanner selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") QBanner record, @Param("example") QBannerExample example);

    int updateByExample(@Param("record") QBanner record, @Param("example") QBannerExample example);

    int updateByPrimaryKeySelective(QBanner record);

    int updateByPrimaryKey(QBanner record);

    /**
     * 前台分页
     *
     * @param page
     * @param params
     * @return
     */
    List<Map<String, Object>> selectPage(Page page, Map<String, Object> params);
}