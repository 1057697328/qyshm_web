package net.lightwing.qyshm_web.dao;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.BaseMapper;
import net.lightwing.qyshm_web.pojo.QCooptype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface QCooptypeDao extends BaseMapper<QCooptype> {

    /**
     * 前台分页
     *
     * @param page
     * @param params
     * @return
     */
    List<Map<String, Object>> selectPage(Page page, Map<String, Object> params);
}