package net.lightwing.qyshm_web.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.BaseMapper;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.pojo.QTeamExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface QTeamDao extends BaseMapper<QTeam> {
    /**
     * 前台分页
     *
     * @param page
     * @param params
     * @return
     */
    List<Map<String, Object>> selectPage(Page page, Map<String, Object> params);
}