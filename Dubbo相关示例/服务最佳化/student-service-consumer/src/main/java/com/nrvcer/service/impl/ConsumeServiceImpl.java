package com.nrvcer.service.impl;

import com.nrvcer.service.ConsumeService;
import com.nrvcer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ConsumeServiceImpl implements ConsumeService {
    @Autowired

    private StudentService studentService;
    public String queryStudent(Integer id) {
        return "学生id:" + id + ",学生信息:" + studentService.queryStudentById(id).toString();
    }
    public Integer queryStudentCount() {
        return studentService.queryStudentCount();
    }
}
