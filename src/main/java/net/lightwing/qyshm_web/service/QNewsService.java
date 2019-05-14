package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QNewsDao;
import net.lightwing.qyshm_web.pojo.QNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QNewsService {

    @Autowired
    private QNewsDao qNewsDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("nid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qNewsDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QNews qNews) {
        return qNewsDao.insertSelective(qNews);
    }

    public int update(QNews qNews) {
        return qNewsDao.updateByPrimaryKeySelective(qNews);
    }

    public int delete(Integer cid) {
        return qNewsDao.deleteByPrimaryKey(cid);
    }

    public List<QNews> selectByName(String name) {
        Example example = new Example(QNews.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ntitle", name);
        return qNewsDao.selectByExample(example);
    }

    public QNews selectById(Integer cid) {
        return qNewsDao.selectByPrimaryKey(cid);
    }

}
