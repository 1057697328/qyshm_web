package net.lightwing.qyshm_web.controller;

import net.lightwing.qyshm_web.commons.util.HtmlUtils;
import net.lightwing.qyshm_web.commons.util.PageInfo;
import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QCoop;
import net.lightwing.qyshm_web.pojo.QCooptype;
import net.lightwing.qyshm_web.pojo.QTeam;
import net.lightwing.qyshm_web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Controller
public class CoopTypeController {

    @Autowired
    private QCooptypeService qCooptypeService;

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

    @RequestMapping("coop.html")
    public String selectWebPageInfo(Model model) {
//        Map<String, Object> params = new HashMap<>();
//        PageInfo pageInfo = new PageInfo(page, limit);
        List<QCooptype> qCooptypeList = qCooptypeService.getList();
        PageInfo qb = new PageInfo(1, 9);
        qb = qBottommenuService.selectPageInfo(qb);
        PageInfo qc = new PageInfo(1, 1);
        qc = qConfigService.selectPageInfo(qc);
        PageInfo qq = new PageInfo(1, 2);
        qq = qQrcodeService.selectPageInfo(qq);
        PageInfo qt = new PageInfo(1, 100000);
        qt = qTechdevService.selectPageInfo(qt);
        PageInfo qp = new PageInfo(1, 100000);
        qp = qProductService.selectPageInfo(qp);

        for (QCooptype type : qCooptypeList) {

            for (QCoop coop : type.getCoops()) {
                String html = HtmlUtils.Html2Text(coop.getCtedail());
                coop.setCtedail(html);
            }


        }


        model.addAttribute("qCooptypeList", qCooptypeList);
        model.addAttribute("qb", qb);
        model.addAttribute("qc", qc);
        model.addAttribute("qq", qq);
        model.addAttribute("qt", qt);
        model.addAttribute("qp", qp);
        return "coop";
    }

}
