package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QConfig;
import net.lightwing.qyshm_web.service.QConfigService;
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
@RequestMapping("admin/config")
public class QConfigController {
    @Autowired
    private QConfigService qConfigService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qConfigService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QConfig QConfig) {
        List<QConfig> result = qConfigService.selectByName(QConfig.getAddress());
        if (result.size() > 0) {
            return WrapMapper.ok().message("该地址已存在");
        }
        qConfigService.insert(QConfig);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QConfig QConfig) {
        qConfigService.update(QConfig);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer bmid) {
        qConfigService.delete(bmid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer bmid) {
        QConfig QConfig = qConfigService.selectById(bmid);
        return WrapMapper.ok().result(QConfig);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectByName(String name) {
        List<QConfig> QConfig = qConfigService.selectByName(name);
        return WrapMapper.ok().result(QConfig);
    }
}
