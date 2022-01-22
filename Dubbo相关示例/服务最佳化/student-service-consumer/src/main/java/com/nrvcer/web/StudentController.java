package com.nrvcer.web;

import com.nrvcer.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    @Qualifier(value = "consumeService")
    private ConsumeService consumeService;
    @RequestMapping("/query")
    @ResponseBody
    public String getData(Integer id) {
        return consumeService.queryStudent(id) + consumeService.queryStudentCount().toString();
    }
}
