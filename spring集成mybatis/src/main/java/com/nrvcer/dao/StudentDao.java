package com.nrvcer.dao;

import com.nrvcer.domain.Student;

import java.util.List;

public interface StudentDao {
    Integer insert(Student student);
    Integer delete(Integer id);
    Integer update(Student student);
    List<Student> selectById(Integer id);
}
