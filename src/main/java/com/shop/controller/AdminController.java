package com.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AdminController {

    @RequestMapping(value = "/adminpage", method = RequestMethod.GET)
    public String adminpage(){
        return "views-admin-adminpage";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(){
        return "views-admin-category";
    }


}
