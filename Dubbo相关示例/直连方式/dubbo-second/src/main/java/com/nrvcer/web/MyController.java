package com.nrvcer.web;

import com.nrvcer.domain.Student;
import com.nrvcer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @Autowired
    @Qualifier(value="remoteStudentService")
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value="/student")
    public String studentDatail(Model model, Integer id) {
        // 调用远程方法查询学生信息
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student", student);
        return "studentDetail";
    }
}
