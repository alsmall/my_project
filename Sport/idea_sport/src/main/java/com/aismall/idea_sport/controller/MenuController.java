package com.aismall.idea_sport.controller;

import com.aismall.idea_sport.bean.MainMenu;
import com.aismall.idea_sport.dao.MenuDao;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus(){
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> mainMenus = menuDao.getMainMenus();
        data.put("data", mainMenus);
        data.put("status",200);
        String data_json = JSON.toJSONString(data);
        System.out.println("成功访问！！！");
        return data_json;
    }
}
