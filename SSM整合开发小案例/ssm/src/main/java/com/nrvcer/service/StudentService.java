package com.nrvcer.service;

import com.nrvcer.domain.Student;

import java.util.List;

public interface StudentService {
    public abstract int addStudent(Student student);
    public abstract List<Student> queryStudents();
}
