package com.nrvcer.service.impl;

import com.nrvcer.domain.Student;
import com.nrvcer.service.ConsumeService;
import com.nrvcer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ConsumeServiceImpl implements ConsumeService {
    @Autowired
    @Qualifier(value = "remoteStudentService")
    private StudentService studentService;
    @Override
    public Student queryStudentById(Integer id) {
        return studentService.queryStudentById(id);
    }
}
