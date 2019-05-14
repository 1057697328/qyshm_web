package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QTeamtype;
import net.lightwing.qyshm_web.service.QTeamTypeService;
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
@RequestMapping("admin/teamType")
public class QTeamTypeController {

    @Autowired
    private QTeamTypeService qTeamTypeService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qTeamTypeService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QTeamtype qTeamtype) {
        List<QTeamtype> qTeamList = qTeamTypeService.selectByName(qTeamtype.getTtypename());
        if (qTeamList.size() > 0) {
            return WrapMapper.ok().message("该团队类型名称已存在");
        }
        qTeamTypeService.insert(qTeamtype);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QTeamtype qTeamtype) {
        qTeamTypeService.update(qTeamtype);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer nid) {
        qTeamTypeService.delete(nid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QTeamtype qTeamtype = qTeamTypeService.selectById(cid);
        return WrapMapper.ok().result(qTeamtype);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectById(String name) {
        List<QTeamtype> qTeamList = qTeamTypeService.selectByName(name);
        return WrapMapper.ok().result(qTeamList);
    }

}
