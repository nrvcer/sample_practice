package com.nrvcer.service.impl;

import com.nrvcer.dao.StudentDao;
import com.nrvcer.domain.Student;
import com.nrvcer.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    // 向Service注入Mapper代理对象
    @Resource
    private StudentDao studentDao;
    @Override
    public Integer insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public Integer delete(Integer id) {
        return studentDao.delete(id);
    }

    @Override
    public Integer update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public List<Student> selectById(Integer id) {
        return studentDao.selectById(id);
    }
}
