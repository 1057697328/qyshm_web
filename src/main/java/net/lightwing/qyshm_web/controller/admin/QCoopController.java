package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.util.UPLOAD;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QCoop;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.service.QCoopService;
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
    public Wrapper insert(QCoop qCoop, @RequestParam(value = "imgFile", required = false) MultipartFile file) {
        List<QCoop> qCoopList = qCoopService.selectByName(qCoop.getCname());
        if (qCoopList.size() > 0) {
            return WrapMapper.ok().message("该合作机构名称已存在");
        }
        if (file != null) {
            if (StringUtils.isNotBlank(file.getOriginalFilename())) {
                qCoop.setCoverimg(null);
                if (qCoop.getCoverimg() != null) {
                    String deletepath = qCoop.getCoverimg().substring(1, qCoop.getCoverimg().length());
                    UPLOAD.deleteFile(deletepath);
                }
                Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
                if ((int) upload.get("code") == 200) {
                    qCoop.setCoverimg("/pictures/" + upload.get("filename"));
                }
            }
        }
        qCoopService.insert(qCoop);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(QCoop qCoop,@RequestParam(value = "imgFile", required = false) MultipartFile file) {
       System.out.println("_________________________________进来了");
        if (file != null) {
            if (StringUtils.isNotBlank(file.getOriginalFilename())) {
                qCoop.setCoverimg(null);
                if (qCoop.getCoverimg() != null) {
                    String deletepath = qCoop.getCoverimg().substring(1, qCoop.getCoverimg().length());
                    UPLOAD.deleteFile(deletepath);
                }
                Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
                if ((int) upload.get("code") == 200) {
                    qCoop.setCoverimg("/pictures/" + upload.get("filename"));
                    QCoop result = qCoopService.selectById(qCoop.getCid());
                    if (result.getCoverimg() != null) {
                        UPLOAD.deleteFile(result.getCoverimg());
                    }
                }
            }
        }
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
