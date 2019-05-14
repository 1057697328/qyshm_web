package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QCoop;
import net.lightwing.qyshm_web.service.QCoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/coop")
public class QCoopController {

    @Autowired
    private QCoopService qCoopService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qCoopService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QCoop qCoop) {
        List<QCoop> qCoopList = qCoopService.selectByName(qCoop.getCname());
        if (qCoopList.size() > 0) {
            return WrapMapper.ok().message("该合作机构名称已存在");
        }
        qCoopService.insert(qCoop);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QCoop qCoop) {
        qCoopService.update(qCoop);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer cid) {
        qCoopService.delete(cid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QCoop qCoop = qCoopService.selectById(cid);
        return WrapMapper.ok().result(qCoop);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectById(String name) {
        List<QCoop> qCooplist = qCoopService.selectByName(name);
        return WrapMapper.ok().result(qCooplist);
    }
}
