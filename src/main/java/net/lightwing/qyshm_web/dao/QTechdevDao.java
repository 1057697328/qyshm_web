package net.lightwing.qyshm_web.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.BaseMapper;
import net.lightwing.qyshm_web.pojo.QTechdev;
import net.lightwing.qyshm_web.pojo.QTechdevExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QTechdevDao extends BaseMapper<QTechdev> {
    /**
     * 前台分页
     *
     * @param page
     * @param params
     * @return
     */
    List<Map<String, Object>> selectPage(Page page, Map<String, Object> params);

    QTechdev selectByPrimaryKey(@Param("cid") Object cid);
}