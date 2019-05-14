package net.lightwing.qyshm_web.dao;

import net.lightwing.qyshm_web.commons.util.BaseMapper;
import net.lightwing.qyshm_web.pojo.QAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QAdminDao extends BaseMapper<QAdmin> {

    QAdmin selectByName(@Param("name") String name);
}