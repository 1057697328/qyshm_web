package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.util.UPLOAD;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QBanner;
import net.lightwing.qyshm_web.service.QBannerService;
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
@RequestMapping("admin/banner")
public class QBannerController {
    @Autowired
    private QBannerService qBannerService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qBannerService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(@RequestBody QBanner qBanner, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qBanner.setImgpath(null);
            if (qBanner.getImgpath() != null) {
                String deletepath = qBanner.getImgpath().substring(1, qBanner.getImgpath().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qBanner.setImgpath("/pictures/" + upload.get("filename"));
            }
        }
        qBannerService.insert(qBanner);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(@RequestBody QBanner qBanner, @RequestParam("imgFile") MultipartFile file) {

        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qBanner.setImgpath(null);
            if (qBanner.getImgpath() != null) {
                String deletepath = qBanner.getImgpath().substring(1, qBanner.getImgpath().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qBanner.setImgpath("/pictures/" + upload.get("filename"));
                QBanner result = qBannerService.selectById(qBanner.getBid());
                if (result.getImgpath() != null) {
                    UPLOAD.deleteFile(result.getImgpath());
                }
            }
        }
        qBannerService.update(qBanner);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer bid) {
        QBanner qBanner = qBannerService.selectById(bid);
        return WrapMapper.ok().message("删除成功").result(qBanner);
    }

}
