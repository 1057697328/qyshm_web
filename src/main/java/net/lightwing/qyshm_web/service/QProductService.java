package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QProductDao;
import net.lightwing.qyshm_web.pojo.QBanner;
import net.lightwing.qyshm_web.pojo.QNews;
import net.lightwing.qyshm_web.pojo.QProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QProductService {

    @Autowired
    private QProductDao qProductDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("pid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qProductDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QProduct qProduct) {
        return qProductDao.insertSelective(qProduct);
    }

    public int update(QProduct qProduct) {
        Example example = new Example(QProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid",qProduct.getPid());
        return qProductDao.updateByExample(qProduct,example);
    }

    public int delete(Integer cid) {
        Example example = new Example(QProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid",cid);
        return qProductDao.deleteByExample(example);
    }

    public List<QProduct> selectByName(String name) {
        Example example = new Example(QProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pname", name);
        return qProductDao.selectByExample(example);
    }

    public QProduct selectById(Integer cid) {
        Example example = new Example(QProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid", cid);
        return qProductDao.selectOneByExample(example);
    }

}
