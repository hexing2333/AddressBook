package cn.edu.bupt.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login(Model model){
        //GET页面 返回login主页
        return "login";
    }
    @PostMapping
    public String addSession(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpServletRequest request, HttpServletResponse response) throws IOException {
        //POST表单提交到/login，将username和isLogin设置后添加到Session中，并重定向到主页
        System.out.println("添加Session");
        HttpSession session=request.getSession();
        session.setAttribute("islogin","true");
        session.setAttribute("username",username);
        return "redirect:/index";
    }
}
