package com.nrvcer.dao;

import com.nrvcer.domain.Student;

import java.util.List;

public interface StudentDao {
    public abstract int insertStudent(Student student);
    public abstract List<Student> selectStudents();
}
