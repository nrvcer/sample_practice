package com.nrvcer.web;

import com.nrvcer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value="/queryStudent")
    @ResponseBody
    public String queryStudent(Integer id, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        return "学生id:" + id + ",学生信息为:" +
                studentService.queryStudentById(id).toString();
    }
}
