package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QTeamtypeDao;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.pojo.QTeamtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class QTeamTypeService {

    @Autowired
    private QTeamtypeDao qTeamtypeDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("ttypeid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qTeamtypeDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QTeamtype qTeamtype) {
        return qTeamtypeDao.insertSelective(qTeamtype);
    }

    public int update(QTeamtype qTeamtype) {
        Example example = new Example(QTeam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ttypeid",qTeamtype.getTtypeid());
        return qTeamtypeDao.updateByExample(qTeamtype,example);
    }

    public int delete(Integer cid) {
        Example example = new Example(QTeamtype.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ttypeid",cid);
        return qTeamtypeDao.deleteByExample(example);
    }

    public List<QTeamtype> selectByName(String name) {
        Example example = new Example(QTeamtype.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ttypename", name);
        return qTeamtypeDao.selectByExample(example);
    }

    public QTeamtype selectById(Integer cid) {
        Example example = new Example(QTeamtype.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ttypeid", cid);
        return qTeamtypeDao.selectOneByExample(example);
    }



}
