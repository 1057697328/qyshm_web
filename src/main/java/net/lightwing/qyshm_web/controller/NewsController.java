package net.lightwing.qyshm_web.controller;

import net.lightwing.qyshm_web.commons.util.HtmlUtils;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.pojo.QNews;
import net.lightwing.qyshm_web.service.QBottommenuService;
import net.lightwing.qyshm_web.service.QConfigService;
import net.lightwing.qyshm_web.service.QNewsService;
import net.lightwing.qyshm_web.service.QQrcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private QNewsService qNewsService;
    @Autowired
    private QBottommenuService qBottommenuService;

    @Autowired
    private QConfigService qConfigService;

    @Autowired
    private QQrcodeService qQrcodeService;


    @RequestMapping("selectWebPageInfo")
    public String selectWebPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, Model model) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qNewsService.selectPageInfo(pageInfo);
        List<QNews> qNewsList = pageInfo.getRows();
        List<QNews> qNewsResult = new ArrayList<>();
        for (QNews str : qNewsList) {
            QNews qNews = new QNews();
            String html = HtmlUtils.Html2Text(str.getNdetail());
            if (html.length() > 50) {
                qNews.setNdetail(html.substring(0, 50) + "……");
            } else {
                qNews.setNdetail(html);
            }
            qNews.setCreatetime(str.getCreatetime());
            qNews.setCoverimg(str.getCoverimg());
            qNews.setNid(str.getNid());
            qNews.setNtitle(str.getNtitle());
            qNewsResult.add(qNews);
        }
        PageInfo qb = new PageInfo(1, 9);
        qb = qBottommenuService.selectPageInfo(qb);
        PageInfo qc = new PageInfo(1, 1);
        qc = qConfigService.selectPageInfo(qc);
        PageInfo qq = new PageInfo(1, 2);
        qq = qQrcodeService.selectPageInfo(qq);
        model.addAttribute("PageInfo", pageInfo);
        model.addAttribute("qb", qb);
        model.addAttribute("qc", qc);
        model.addAttribute("qq", qq);
        return "";
    }

    /**
     * 根据新闻编号编号查询详情
     *
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping("selectById")
    public String selectById(Integer cid, Model model) {
        QNews qNews = qNewsService.selectById(cid);
        PageInfo qb = new PageInfo(1, 9);
        qb = qBottommenuService.selectPageInfo(qb);
        PageInfo qc = new PageInfo(1, 1);
        qc = qConfigService.selectPageInfo(qc);
        PageInfo qq = new PageInfo(1, 2);
        qq = qQrcodeService.selectPageInfo(qq);
        model.addAttribute("qCoop", qNews);
        model.addAttribute("qb", qb);
        model.addAttribute("qc", qc);
        model.addAttribute("qq", qq);
        return "";
    }
}
