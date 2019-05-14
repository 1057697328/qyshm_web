package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QTeamDao;
import net.lightwing.qyshm_web.pojo.QTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class QTeamService {

    @Autowired
    private QTeamDao qTeamDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("tid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qTeamDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QTeam qTeam) {
        return qTeamDao.insertSelective(qTeam);
    }

    public int update(QTeam qTeam) {
        return qTeamDao.updateByPrimaryKeySelective(qTeam);
    }

    public int delete(Integer cid) {
        return qTeamDao.deleteByPrimaryKey(cid);
    }

    public List<QTeam> selectByName(String name) {
        Example example = new Example(QTeam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        return qTeamDao.selectByExample(example);
    }

    public QTeam selectById(Integer cid) {
        return qTeamDao.selectByPrimaryKey(cid);
    }


}
