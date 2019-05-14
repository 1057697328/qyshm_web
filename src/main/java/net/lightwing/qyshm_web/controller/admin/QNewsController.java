package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.util.UPLOAD;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QNews;
import net.lightwing.qyshm_web.service.QNewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/news")
public class QNewsController {

    @Autowired
    private QNewsService qNewsService;

    @RequestMapping("selectAdminPageInfo")
    @ResponseBody
    public Wrapper selectAdminPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qNewsService.selectPageInfo(pageInfo);
        return WrapMapper.ok().result(pageInfo);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Wrapper insert(QNews qNews, @RequestParam("imgFile") MultipartFile file) {
        List<QNews> qCoopTypeList = qNewsService.selectByName(qNews.getNtitle());
        if (qCoopTypeList.size() > 0) {
            return WrapMapper.ok().message("该新闻标题已存在");
        }
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qNews.setCoverimg(null);
            if (qNews.getCoverimg() != null) {
                String deletepath = qNews.getCoverimg().substring(1, qNews.getCoverimg().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qNews.setCoverimg("/pictures/" + upload.get("filename"));
            }
        }
        qNewsService.insert(qNews);
        return WrapMapper.ok().message("新增成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public Wrapper update(QNews qNews, @RequestParam("imgFile") MultipartFile file) {
        if (StringUtils.isNotBlank(file.getOriginalFilename())) {
            qNews.setCoverimg(null);
            if (qNews.getCoverimg() != null) {
                String deletepath = qNews.getCoverimg().substring(1, qNews.getCoverimg().length());
                UPLOAD.deleteFile(deletepath);
            }
            Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
            if ((int) upload.get("code") == 200) {
                qNews.setCoverimg("/pictures/" + upload.get("filename"));
                QNews result = qNewsService.selectById(qNews.getNid());
                if (result.getCoverimg() != null) {
                    UPLOAD.deleteFile(result.getCoverimg());
                }
            }
        }
        qNewsService.update(qNews);
        return WrapMapper.ok().message("修改成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public Wrapper delete(Integer nid) {
        QNews result = qNewsService.selectById(nid);
        if (result.getCoverimg() != null) {
            UPLOAD.deleteFile(result.getCoverimg());
        }
        qNewsService.delete(nid);
        return WrapMapper.ok().message("删除成功");
    }

    @RequestMapping("selectById")
    @ResponseBody
    public Wrapper selectById(Integer cid) {
        QNews qNews = qNewsService.selectById(cid);
        return WrapMapper.ok().result(qNews);
    }

    @RequestMapping("selectByName")
    @ResponseBody
    public Wrapper selectById(String name) {
        List<QNews> qNewsList = qNewsService.selectByName(name);
        return WrapMapper.ok().result(qNewsList);
    }
}
