package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.util.UPLOAD;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QQrcode;
import net.lightwing.qyshm_web.service.QQrcodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin/qrcode")
public class QQrcodeController {

    @Autowired
    private QQrcodeService qQrcodeService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qQrcodeService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(QQrcode qrcode, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qrcode.setImgpath(null);
            if (qrcode.getImgpath() != null) {
                String deletepath = qrcode.getImgpath().substring(1, qrcode.getImgpath().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qrcode.setImgpath("/pictures/" + upload.get("filename"));
            }
        }
        qQrcodeService.insert(qrcode);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(QQrcode qrcode, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qrcode.setImgpath(null);
            if (qrcode.getImgpath() != null) {
                String deletepath = qrcode.getImgpath().substring(1, qrcode.getImgpath().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qrcode.setImgpath("/pictures/" + upload.get("filename"));
                QQrcode result = qQrcodeService.selectById(qrcode.getQid());
                if (result.getImgpath() != null) {
                    UPLOAD.deleteFile(result.getImgpath());
                }
            }
        }
        qQrcodeService.update(qrcode);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer nid) {
        QQrcode result = qQrcodeService.selectById(nid);
        if (result.getImgpath() != null) {
            UPLOAD.deleteFile(result.getImgpath());
        }
        qQrcodeService.delete(nid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QQrcode qrcode = qQrcodeService.selectById(cid);
        return WrapMapper.ok().result(qrcode);
    }

}
