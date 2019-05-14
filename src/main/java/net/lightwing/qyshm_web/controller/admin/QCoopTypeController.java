package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QCoop;
import net.lightwing.qyshm_web.pojo.QCooptype;
import net.lightwing.qyshm_web.service.QCoopService;
import net.lightwing.qyshm_web.service.QCooptypeService;
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
public class QCoopTypeController {

    @Autowired
    private QCooptypeService qCooptypeService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qCooptypeService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QCooptype qCooptype) {
        List<QCooptype> qCoopTypeList = qCooptypeService.selectByName(qCooptype.getCtypename());
        if (qCoopTypeList.size() > 0) {
            return WrapMapper.ok().message("该合作机构类型已存在");
        }
        qCooptypeService.insert(qCooptype);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QCooptype qCooptype) {
        qCooptypeService.update(qCooptype);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer cid) {
        qCooptypeService.delete(cid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QCooptype qCooptype = qCooptypeService.selectById(cid);
        return WrapMapper.ok().result(qCooptype);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectById(String name) {
        List<QCooptype> qCooptypeList = qCooptypeService.selectByName(name);
        return WrapMapper.ok().result(qCooptypeList);
    }
}
