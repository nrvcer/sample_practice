package com.nrvcer.web;

import com.nrvcer.domain.Student;
import com.nrvcer.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {
    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping(value="/select")
    @ResponseBody
    public String selectStudentById(Integer id) {
        String result = "";
        List<Student> students = studentService.selectById(id);
        if (students != null && students.size() != 0) {
            for (Student student : students) {
                result += student.toString();
            }
        }
        return result;
    }
    @RequestMapping(value="/update")
    @ResponseBody
    public  String updateStudent(Student student) {
        return "改变的记录行数：" + studentService.update(student).toString();
    }
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insertStudent(Student student) {
        return "插入的记录行数:" + studentService.insert(student).toString();
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String deleteStudent(Integer id) {
        return "删除的记录数：" + studentService.delete(id).toString();
    }

}
