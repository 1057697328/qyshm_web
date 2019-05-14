package net.lightwing.qyshm_web.dao;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.BaseMapper;
import net.lightwing.qyshm_web.pojo.QBottommenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface QBottommenuDao extends BaseMapper<QBottommenu> {
//    long countByExample(QBottommenuExample example);
//
//    int deleteByExample(QBottommenuExample example);
//
//    int deleteByPrimaryKey(Integer bmid);
//
//    int insert(QBottommenu record);
//
//    int insertSelective(QBottommenu record);

//    List<QBottommenu> selectByExample(QBottommenuExample example);

//    QBottommenu selectByPrimaryKey(Integer bmid);
//
//    int updateByExampleSelective(@Param("record") QBottommenu record, @Param("example") QBottommenuExample example);
//
//    int updateByExample(@Param("record") QBottommenu record, @Param("example") QBottommenuExample example);
//
//    int updateByPrimaryKeySelective(QBottommenu record);
//
//    int updateByPrimaryKey(QBottommenu record);

    /**
     * 前台分页
     *
     * @param page
     * @param params
     * @return
     */
    List<Map<String, Object>> selectPage(Page page, Map<String, Object> params);
}