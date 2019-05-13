package net.lightwing.qyshm_web.service;

import net.lightwing.qyshm_web.dao.QAdminDao;
import net.lightwing.qyshm_web.pojo.QAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : clarence
 * 创建时间 : 2019-05-13
 * 长沙轻翼网络科技有限公司
 */
@SuppressWarnings("ALL")
@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class QAdminService
{
    @Autowired
    private QAdminDao dao;

    public void addAdmin(QAdmin admin)
    {
        dao.insert(admin);
    }
}
