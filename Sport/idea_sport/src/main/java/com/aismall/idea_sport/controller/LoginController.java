package com.aismall.idea_sport.controller;

import com.aismall.idea_sport.bean.User;
import com.aismall.idea_sport.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    @ResponseBody
    /*把请求体封装到User对象里面*/
    public String login(@RequestBody User user){
        String str="error";
        int count=userDao.getUserByMessage(user.getUsername(),user.getPassword());
        System.out.println(count);

        if(count>0){
            str="ok";
        }
        return str;
    }
}
