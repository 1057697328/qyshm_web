package net.lightwing.qyshm_web.controller.admin;

import net.lightwing.qyshm_web.commons.wrapper.WrapMapper;
import net.lightwing.qyshm_web.commons.wrapper.Wrapper;
import net.lightwing.qyshm_web.pojo.QAdmin;
import net.lightwing.qyshm_web.service.QAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : clarence
 * 创建时间 : 2019-05-13
 * 长沙轻翼网络科技有限公司
 */
@Controller
@RequestMapping("admin/user")
public class QAdminController {
    @Autowired
    private QAdminService qAdminService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @RequestMapping("loginIn")
    @ResponseBody
    public Wrapper login(HttpSession session, String userName, String pwd) throws Exception {
        QAdmin qAdmin = qAdminService.selectByName(userName);
        if (qAdmin != null) {
            if (qAdmin.getPassword().equals(pwd)) {
                session.setAttribute("user", qAdmin);
                return WrapMapper.ok().message("正在跳转,请稍后……");
            } else {
                return WrapMapper.ok().message("账号或密码错误");
            }
        } else {
            return WrapMapper.ok().code("400").message("该账户不存在");
        }

    }

    @RequestMapping("/logout")
    public String logout() {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/index.html";
    }

}
