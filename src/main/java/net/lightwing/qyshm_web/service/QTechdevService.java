package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QTechdevDao;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.pojo.QTechdev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QTechdevService {

    @Autowired
    private QTechdevDao qTechdevDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("tid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qTechdevDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QTechdev qTechdev) {
        return qTechdevDao.insertSelective(qTechdev);
    }

    public int update(QTechdev qTechdev) {
        Example example = new Example(QTechdev.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tid",qTechdev.getTid());
        return qTechdevDao.updateByExample(qTechdev,example);
    }

    public int delete(Integer tid) {
        Example example = new Example(QTechdev.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tid",tid);
        return qTechdevDao.deleteByExample(example);
    }

    public List<QTechdev> selectByName(String name) {
        Example example = new Example(QTechdev.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ttitle", name);
        return qTechdevDao.selectByExample(example);
    }

    public QTechdev selectById(Integer cid) {
        return qTechdevDao.selectByPrimaryKey(cid);
    }


}
