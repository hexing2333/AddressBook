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
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    List<item> items=new ArrayList<>();

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("items",items);
        return "index";
    }

    @GetMapping("/deleteItem")
    public String DeleteItem(@RequestParam("itemId") int id){
        System.out.println(id);
        items.remove(id);
        return "redirect:index";
    }

    @PostMapping("/changeItem")
    public String changeItem(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("email") String eamil,
                             @RequestParam("address") String address,
                             @RequestParam("qq") String qq,Model model){
        System.out.println(id);
        items.set(id,new item(name,phone,eamil,address,qq));
        return "redirect:index";
    }

    @PostMapping("/index")
    public String list(@RequestParam("name") String name,
                       @RequestParam("phone") String phone,
                       @RequestParam("email") String eamil,
                       @RequestParam("address") String address,
                       @RequestParam("qq") String qq,
                        HttpServletResponse response
                        ,Model model){
        System.out.println("成功接收POST"+name+phone+eamil);
        items.add(new item(name,phone,eamil,address,qq));
        model.addAttribute("items",items);
        return "index";
    }

    @RequestMapping("/quit")
    public String quit(HttpServletRequest request, HttpServletResponse response){
        //删除Session中的islogin值，并返回登录界面
        HttpSession session=request.getSession();
        session.removeAttribute("islogin");
        items.clear();
        return "redirect:/login";

    }
}
