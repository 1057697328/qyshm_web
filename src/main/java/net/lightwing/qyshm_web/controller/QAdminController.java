package net.lightwing.qyshm_web.controller;

import net.lightwing.qyshm_web.pojo.QAdmin;
import net.lightwing.qyshm_web.service.QAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : clarence
 * 创建时间 : 2019-05-13
 * 长沙轻翼网络科技有限公司
 */
@Controller
@RequestMapping("admin")
public class QAdminController
{
    @Autowired
    private QAdminService service;


}
