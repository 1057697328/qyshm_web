package net.lightwing.qyshm_web.controller;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.pojo.QProduct;
import net.lightwing.qyshm_web.service.QBottommenuService;
import net.lightwing.qyshm_web.service.QConfigService;
import net.lightwing.qyshm_web.service.QProductService;
import net.lightwing.qyshm_web.service.QQrcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private QProductService qProductService;

    @Autowired
    private QBottommenuService qBottommenuService;

    @Autowired
    private QConfigService qConfigService;

    @Autowired
    private QQrcodeService qQrcodeService;


    @RequestMapping("selectWebPageInfo")
    public String selectWebPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit, Model model) {
        Map<String, Object> params = new HashMap<>();
        PageInfo pageInfo = new PageInfo(page, limit);
        pageInfo = qProductService.selectPageInfo(pageInfo);
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
     * 根据产品编号查询详情
     *
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping("selectById")
    public String selectById(Integer cid, Model model) {
        QProduct qProduct = qProductService.selectById(cid);
        PageInfo qb = new PageInfo(1, 9);
        qb = qBottommenuService.selectPageInfo(qb);
        PageInfo qc = new PageInfo(1, 1);
        qc = qConfigService.selectPageInfo(qc);
        PageInfo qq = new PageInfo(1, 2);
        qq = qQrcodeService.selectPageInfo(qq);
        model.addAttribute("qCoop", qProduct);
        model.addAttribute("qb", qb);
        model.addAttribute("qc", qc);
        model.addAttribute("qq", qq);
        return "";
    }
}
