package com.nrvcer.service;

import com.nrvcer.domain.Student;

public class StudentServiceImpl implements StudentService{
    @Override
    public Student queryStudentById(Integer id) {
        Student student = new Student();
        student.setId(id);
        student.setName("NrvCer");
        student.setEmail("666");
        student.setAge(23);
        return student;
    }
}
