package com.nrvcer.service;

import com.nrvcer.domain.Student;
import com.nrvcer.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student queryStudentById(Integer id) {
        Student student = new Student(id, "张三", "110", 23);
        return student;
    }

    @Override
    public Integer queryStudentCount() {
        return 100;
    }
}
