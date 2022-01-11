package com.nrv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = {"/some.do", "/test/add.do"})
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("func", "执行了dosome方法");

        // view文件夹用于保护视图，因为在浏览器中是访问不到WEB-INF目录的
        // mv.setViewName("/WEB-INF/view/show.jsp");

        // 当配置了视图解析器，可以使用文件名称作为视图名使用，叫做视图逻辑名称
        mv.setViewName("other");
        return mv;
    }
}
