package com.nrvcer.service;

import com.nrvcer.domain.Student;

import java.util.List;

public interface StudentService {
    Integer insert(Student student);
    Integer delete(Integer id);
    Integer update(Student student);
    List<Student> selectById(Integer id);
}
