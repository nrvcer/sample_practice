package com.nrvcer.dao;

import com.nrvcer.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Student student);
    // 指定使用不同的列名作为查询条件
    List<Student> selectStudentsByField(@Param("col")String columnName, @Param("cval") Object value);
}
