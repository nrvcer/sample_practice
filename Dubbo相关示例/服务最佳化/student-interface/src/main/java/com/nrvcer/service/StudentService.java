package com.nrvcer.service;

import com.nrvcer.domain.Student;

public interface StudentService {
    Student queryStudentById(Integer id);
    Integer queryStudentCount();
}
