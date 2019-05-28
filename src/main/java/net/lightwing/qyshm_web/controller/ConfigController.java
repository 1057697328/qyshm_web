package net.lightwing.qyshm_web.controller;

import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ConfigController {
    @Autowired
    private QBottommenuService qBottommenuService;

    @Autowired
    private QConfigService qConfigService;

    @Autowired
    private QQrcodeService qQrcodeService;
    @Autowired
    private QTechdevService qTechdevService;

    @Autowired
    private QProductService qProductService;

    @RequestMapping("contactUs.html")
    public String selectWebPageInfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "1") Integer limit, Model model) {
        try {
            Map<String, Object> params = new HashMap<>();
            PageInfo pageInfo = new PageInfo(page, limit);
            pageInfo = qConfigService.selectPageInfo(pageInfo);
            PageInfo qb = new PageInfo(1, 9);
            qb = qBottommenuService.selectPageInfo(qb);
            PageInfo qq = new PageInfo(1, 2);
            qq = qQrcodeService.selectPageInfo(qq);
            PageInfo qt = new PageInfo(1, 100000);
            qt = qTechdevService.selectPageInfo(qt);
            PageInfo qp = new PageInfo(1, 100000);
            qp = qProductService.selectPageInfo(qp);
            PageInfo qc = new PageInfo(1, 1);
            qc = qConfigService.selectPageInfo(qc);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("qc", qc);
            model.addAttribute("qb", qb);
            model.addAttribute("qq", qq);
            model.addAttribute("qt", qt);
            model.addAttribute("qp", qp);

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        return "contactUs";
    }

}
