package cn.edu.bupt.demo.filter;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
public class IndexFilter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
        System.out.println("++++preHandle+++++");
        HttpSession session=request.getSession();
        String islogin=(String)session.getAttribute("islogin");
        //查看session中是否有登录成功标志，若没有则Redirect到login界面
        if(islogin==null) {
            System.out.println("用户未登录");
            response.sendRedirect("/login");
            return false;
        }
        System.out.println("用户已登录");
        return true;
    }
}
