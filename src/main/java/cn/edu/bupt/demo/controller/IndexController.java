package cn.edu.bupt.demo.controller;

import cn.edu.bupt.demo.entity.item;
import cn.edu.bupt.demo.dao.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {
    private itemRepository ItemRepository;
    @Autowired
    public void setItemRepository(itemRepository ItemRepository){
        this.ItemRepository =ItemRepository;
    }
    int count=1;
    List<item> items=new ArrayList<>();
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("items",items);
        return "index";
    }

    @GetMapping("/deleteItem")
    public String DeleteItem(@RequestParam("itemId") int index){
        System.out.println(index);
        long id=items.get(index).getId();
        items.remove(index);

        ItemRepository.deleteById(id);

        return "redirect:index";
    }

    //用于修改当前以index为索引的list中的元素值(修改个人信息)
    @PostMapping("/changeItem")
    public String changeItem(@RequestParam("id") int index,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("email") String eamil,
                             @RequestParam("address") String address,
                             @RequestParam("qq") String qq,Model model){
        System.out.println(index);
        long id = items.get(index).getId();//将List中的索引对应到数据库中元素的索引(index相当于下标，id才是真正的标识)
        Optional<item> itemOptional= ItemRepository.findById(id);
        if(itemOptional.isPresent()){
            item it=itemOptional.get();//修改主键为id的元组
            it.setName(name);
            it.setPhone(phone);
            it.setEmail(eamil);
            it.setAddress(address);
            it.setQq(qq);
            items.set(index,it);//在items中修改
            ItemRepository.save(it);//在数据库中保存
        }


        return "redirect:index";
    }

    //向index post数据，在通讯录list中添加post来的数据
    @PostMapping("/index")
    public String list(@RequestParam("name") String name,
                       @RequestParam("phone") String phone,
                       @RequestParam("email") String eamil,
                       @RequestParam("address") String address,
                       @RequestParam("qq") String qq,
                        HttpServletResponse response
                        ,Model model){
        System.out.println("成功接收POST"+name+phone+eamil);

        item it=new item();//创建item
        it.setId((long)count);
        count++;//id自增
        it.setName(name);
        it.setPhone(phone);
        it.setEmail(eamil);
        it.setAddress(address);
        it.setQq(qq);
        ItemRepository.save(it);//放入数据库
        items.add(it);
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

    @ResponseBody
    @PostMapping("/ajax/checkphone")//通过ajax检查当前电话是否存在
    public String checkphone(@RequestParam("phone") String phone){
        System.out.println(phone);
        String result="";
        for (item each:items
             ) {
            System.out.println(each.getPhone());
            if(each.getPhone().equals(phone)){
                System.out.println("yes");//若电话已存在 则返回success
                result="success";
            }
        }
        return result;//否则返回""
    }
}
