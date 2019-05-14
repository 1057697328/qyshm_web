package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QCoopDao;
import net.lightwing.qyshm_web.pojo.QCoop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QCoopService {

    @Autowired
    private QCoopDao qCoopDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("cid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qCoopDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QCoop qCoop) {
        return qCoopDao.insertSelective(qCoop);
    }

    public int update(QCoop qCoop) {
        return qCoopDao.updateByPrimaryKeySelective(qCoop);
    }

    public int delete(Integer cid) {
        return qCoopDao.deleteByPrimaryKey(cid);
    }

    public List<QCoop> selectByName(String name) {
        Example example = new Example(QCoop.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cname", name);
        return qCoopDao.selectByExample(example);
    }

    public QCoop selectById(Integer cid) {
        return qCoopDao.selectByPrimaryKey(cid);
    }

}
