package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QCooptypeDao;
import net.lightwing.qyshm_web.pojo.QCooptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QCooptypeService {

    @Autowired
    private QCooptypeDao qCooptypeDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("ctypeid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qCooptypeDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QCooptype qCooptype) {
        return qCooptypeDao.insertSelective(qCooptype);
    }

    public int update(QCooptype qCooptype) {
        return qCooptypeDao.updateByPrimaryKeySelective(qCooptype);
    }

    public int delete(Integer cid) {
        return qCooptypeDao.deleteByPrimaryKey(cid);
    }

    public List<QCooptype> selectByName(String name) {
        Example example = new Example(QCooptype.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ctypename", name);
        return qCooptypeDao.selectByExample(example);
    }

    public QCooptype selectById(Integer cid) {
        return qCooptypeDao.selectByPrimaryKey(cid);
    }

}
