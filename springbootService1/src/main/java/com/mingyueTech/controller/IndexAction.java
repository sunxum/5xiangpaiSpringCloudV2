package com.mingyueTech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
    @RequestMapping(value = "/index")
    public String index(){

        return "index";
    }
}
