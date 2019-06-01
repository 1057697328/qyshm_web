package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QConfigDao;
import net.lightwing.qyshm_web.pojo.QBottommenu;
import net.lightwing.qyshm_web.pojo.QConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QConfigService {

    @Autowired
    private QConfigDao qConfigDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("cid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qConfigDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QConfig qConfig) {
        return qConfigDao.insertSelective(qConfig);
    }

    public int update(QConfig qConfig) {
        Example example = new Example(QConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid", qConfig.getCid());
        return qConfigDao.updateByExample(qConfig,example);
    }

    public int delete(Integer cid) {
        return qConfigDao.deleteByPrimaryKey(cid);
    }

    public List<QConfig> selectByName(String name) {
        Example example = new Example(QConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("address", name);
        return qConfigDao.selectByExample(example);
    }

    public QConfig selectById(Integer cid) {
        Example example = new Example(QConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid", cid);
        return qConfigDao.selectOneByExample(example);
    }

}
