package net.lightwing.qyshm_web.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.BaseMapper;
import net.lightwing.qyshm_web.pojo.QCoop;
import net.lightwing.qyshm_web.pojo.QCoopExample;
import org.apache.ibatis.annotations.Param;

public interface QCoopDao extends BaseMapper<QCoop> {

    /**
     * 前台分页
     *
     * @param page
     * @param params
     * @return
     */
    List<Map<String, Object>> selectPage(Page page, Map<String, Object> params);
}