package cn.edu.bupt.demo;

import java.util.ArrayList;
import java.util.List;

public class item {
    public String name;//名称
    public String phone;
    public String email;//邮箱
    public String address;
    public String qq;

    public item(){
        //无参的默认的构造函数
    };
    public item(String name,String phone,String email,String address,String qq) {//有参的构造函数
        this.name = name;
        this.phone= phone;
        this.email = email;
        this.address= address;
        this.qq = qq;
    };
}