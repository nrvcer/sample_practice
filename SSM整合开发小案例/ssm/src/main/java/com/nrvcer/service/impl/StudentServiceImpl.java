package com.nrvcer.service.impl;

import com.nrvcer.dao.StudentDao;
import com.nrvcer.domain.Student;
import com.nrvcer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    /**
     * dao是引用类型，StudentDao类型的对象是在spring的配置文件中创建的对象
     * 引用类型自动注入，@AutoWired
     */
    @Resource
    private StudentDao dao;
    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);
        return rows;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = dao.selectStudents();
        return students;
    }
}
