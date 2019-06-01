package net.lightwing.qyshm_web.service;

import com.baomidou.mybatisplus.plugins.Page;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.dao.QQrcodeDao;
import net.lightwing.qyshm_web.pojo.QProduct;
import net.lightwing.qyshm_web.pojo.QQrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class QQrcodeService {

    @Autowired
    private QQrcodeDao qQrcodeDao;

    public PageInfo selectPageInfo(PageInfo pageInfo) {
        pageInfo.setSort("qid");
        Page<Map<String, Object>> page = new Page<>(pageInfo.getNowpage(), pageInfo.getPagesize());
        page.setOrderByField(pageInfo.getSort());//排序字段
        pageInfo.setOrder("asc");//排序方式
        page.setAsc(pageInfo.getOrder().equalsIgnoreCase("desc"));
        pageInfo.setRows(qQrcodeDao.selectPage(page, pageInfo.getCondition()));//获取数据
        pageInfo.setTotal(page.getTotal());//获取总条数
        return pageInfo;
    }

    public int insert(QQrcode qrcode) {
        return qQrcodeDao.insertSelective(qrcode);
    }

    public int update(QQrcode qrcode) {
        Example example = new Example(QQrcode.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("qid",qrcode.getQid());
        return qQrcodeDao.updateByExample(qrcode,example);
    }

    public int delete(Integer cid) {
        Example example = new Example(QQrcode.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("qid",cid);
        return qQrcodeDao.deleteByExample(example);
    }

//    public List<QProduct> selectByName(String name) {
//        Example example = new Example(QProduct.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("ntitle", name);
//        return qQrcodeDao.selectByExample(example);
//    }

    public QQrcode selectById(Integer cid) {
        Example example = new Example(QQrcode.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("qid",cid);
        return qQrcodeDao.selectOneByExample(example);
    }


}
