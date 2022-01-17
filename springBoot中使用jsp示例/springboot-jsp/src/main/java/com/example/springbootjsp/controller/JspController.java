package com.example.springbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JspController {
    @RequestMapping(value="/jsp")
    public String doJsp(Model model) {
        model.addAttribute("data", "SpringBoot中使用jsp");
        // 返回视图逻辑名称
        return "index";
    }
}
