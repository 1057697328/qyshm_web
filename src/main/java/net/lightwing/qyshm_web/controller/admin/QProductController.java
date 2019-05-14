package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.util.UPLOAD;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QProduct;
import net.lightwing.qyshm_web.service.QProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin/product")
public class QProductController {

    @Autowired
    private QProductService qProductService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qProductService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(QProduct qProduct, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qProduct.setQcoverimg(null);
            if (qProduct.getQcoverimg() != null) {
                String deletepath = qProduct.getQcoverimg().substring(1, qProduct.getQcoverimg().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qProduct.setQcoverimg("/pictures/" + upload.get("filename"));
            }
        }
        qProductService.insert(qProduct);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(QProduct qProduct, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qProduct.setQcoverimg(null);
            if (qProduct.getQcoverimg() != null) {
                String deletepath = qProduct.getQcoverimg().substring(1, qProduct.getQcoverimg().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qProduct.setQcoverimg("/pictures/" + upload.get("filename"));
                QProduct result = qProductService.selectById(qProduct.getPid());
                if (result.getQcoverimg() != null) {
                    UPLOAD.deleteFile(result.getQcoverimg());
                }
            }
        }
        qProductService.update(qProduct);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer nid) {
        QProduct result = qProductService.selectById(nid);
        if (result.getQcoverimg() != null) {
            UPLOAD.deleteFile(result.getQcoverimg());
        }
        qProductService.delete(nid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QProduct qProduct = qProductService.selectById(cid);
        return WrapMapper.ok().result(qProduct);
    }

}
