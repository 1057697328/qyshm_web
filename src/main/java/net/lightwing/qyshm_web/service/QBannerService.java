package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QBannerDao;
import net.lightwing.qyshm_web.pojo.QBanner;
import net.lightwing.qyshm_web.pojo.QBottommenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class QBannerService {
    @Autowired
    private QBannerDao qBannerDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("bid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qBannerDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QBanner qBanner) {
        return qBannerDao.insertSelective(qBanner);
    }

    public int update(QBanner qBanner) {
        return qBannerDao.updateByPrimaryKeySelective(qBanner);
    }

    public int delete(Integer bid) {
        return qBannerDao.deleteByPrimaryKey(bid);
    }

    public QBanner selectById(Integer bid) {
        return qBannerDao.selectByPrimaryKey(bid);
    }
    public List<QBanner> selectByName(String name) {
        Example example = new Example(QBottommenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("href", name);
        return qBannerDao.selectByExample(example);
    }
}
