package net.lightwing.qyshm_web.commons.util;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    private List<String> url = new ArrayList();

    /**
     * 开始进入地址请求拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("----------------------进来了-----------------");
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(JSON.toJSONString(MessageBack.MSG(500,"请重新登录")));
            out.flush();
            out.close();
            return false;
        }
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * 定义排除拦截URL
     *
     * @return
     */
    public List<String> getUrl() {
        url.add("/admin/a.html");   //登录页
        url.add("/admin/user/loginIn");   //登录action URL
        //网站静态资源
        url.add("/static/css/**");
        url.add("/static/js/**");
        url.add("/static/lib/**");
        url.add("/static/fonts/**");
        url.add("/static/images/**");
        url.add("/static/admin/**");
        return url;
    }
}
