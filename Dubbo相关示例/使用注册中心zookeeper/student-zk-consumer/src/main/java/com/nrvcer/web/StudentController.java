package com.nrvcer.web;

import com.nrvcer.domain.Student;
import com.nrvcer.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    @Qualifier(value="consumeService")
    private ConsumeService consumeService;

    @RequestMapping(value="/query")
    public String queryStudent(Integer id, Model model) {
        Student student = consumeService.queryStudentById(id);
        model.addAttribute("student", student);
        return "result";
    }
}
