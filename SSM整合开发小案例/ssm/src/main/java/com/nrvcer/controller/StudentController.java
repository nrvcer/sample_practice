package com.nrvcer.controller;

import com.nrvcer.domain.Student;
import com.nrvcer.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/student")
public class StudentController {
    /**
     * 声明引用类型，调用引用类型的业务方法
     * 引用类型自动注入，使用@Autowired或者@Resource
     */
    @Resource(name = "studentService")
    private StudentService service;

    // 添加学生
    @RequestMapping(value="/addStudent.do")
    public ModelAndView addStudent(Student student) {
        System.out.println("addStudent.do请求被处理！");
        ModelAndView modelAndView = new ModelAndView();
        // 调用service,处理业务逻辑，将处理结果返回用户
        int rows = service.addStudent(student);
        String msg = "注册失败！";
        if (rows > 0) {
            // 注册成功，给用户成功的数据和视图
            msg = "注册成功";
        }
        modelAndView.addObject("msg", student.getName() + "," + msg);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    // 查询学生，响应Ajax请求，输出数据
    @RequestMapping(value = "/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudents() {
        List<Student> students = service.queryStudents();
        return students;
    }
}
