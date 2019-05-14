package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.util.UPLOAD;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QCooptype;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.service.QTeamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/team")
public class QTeamController {

    @Autowired
    private QTeamService qTeamService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qTeamService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QTeam qTeam, @RequestParam("imgFile") MultipartFile file) {
        List<QTeam> qTeamList = qTeamService.selectByName(qTeam.getName());
        if (qTeamList.size() > 0) {
            return WrapMapper.ok().message("该人员姓名已存在");
        }
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qTeam.setTheadimg(null);
            if (qTeam.getTheadimg() != null) {
                String deletepath = qTeam.getTheadimg().substring(1, qTeam.getTheadimg().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qTeam.setTheadimg("/pictures/" + upload.get("filename"));
            }
        }
        qTeamService.insert(qTeam);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QTeam qTeam, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qTeam.setTheadimg(null);
            if (qTeam.getTheadimg() != null) {
                String deletepath = qTeam.getTheadimg().substring(1, qTeam.getTheadimg().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qTeam.setTheadimg("/pictures/" + upload.get("filename"));
                QTeam result = qTeamService.selectById(qTeam.getTid());
                if (result.getTheadimg() != null) {
                    UPLOAD.deleteFile(result.getTheadimg());
                }
            }
        }
        qTeamService.update(qTeam);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer nid) {
        QTeam result = qTeamService.selectById(nid);
        if (result.getTheadimg() != null) {
            UPLOAD.deleteFile(result.getTheadimg());
        }
        qTeamService.delete(nid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QTeam qTeam = qTeamService.selectById(cid);
        return WrapMapper.ok().result(qTeam);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectById(String name) {
        List<QTeam> qTeamList = qTeamService.selectByName(name);
        return WrapMapper.ok().result(qTeamList);
    }

}
