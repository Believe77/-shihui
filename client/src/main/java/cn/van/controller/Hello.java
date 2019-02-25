package cn.van.controller;

import cn.van.entity.User;
import cn.van.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class Hello {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }

    @RequestMapping("save")
    public String saveUser() {

        User user = new User();
        user.setName("3");
        user.setName("sdhfj");
        user.setPassword("344335");

        System.out.println(user.toString());
        testService.save(user);
        return "hello";
    }

    @RequestMapping("/regist")
    @ResponseBody
    public String regist(User user){

        User u=testService.findUser(user);//判断注册时用户名是否存在
        if(u!=null)
        {
            return "fail";
        }else{

            testService.regist(user);
            return "success";
        }

    }
}
