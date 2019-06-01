package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QBottommenu;
import net.lightwing.qyshm_web.service.QBottommenuService;
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
@RequestMapping("admin/bottommenu")
public class QBottommenuController {

    @Autowired
    private QBottommenuService qBottommenuService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qBottommenuService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QBottommenu qBottommenu) {
        List<QBottommenu> result = qBottommenuService.selectByName(qBottommenu.getBmtitle());
        if (result.size() > 0) {
            return WrapMapper.ok().message("底部菜单名称已存在");
        }
        qBottommenuService.insert(qBottommenu);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QBottommenu qBottommenu) {
        qBottommenuService.update(qBottommenu);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer bmid) {
        qBottommenuService.delete(bmid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer bmid) {
        QBottommenu qBottommenu = qBottommenuService.selectById(bmid);
        return WrapMapper.ok().result(qBottommenu);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectByName(String name) {
        List<QBottommenu> qBottommenu = qBottommenuService.selectByName(name);
        return WrapMapper.ok().result(qBottommenu);
    }
}
