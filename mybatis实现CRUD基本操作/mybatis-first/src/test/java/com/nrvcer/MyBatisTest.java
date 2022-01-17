package com.nrvcer;

import com.github.pagehelper.PageHelper;
import com.nrvcer.dao.StudentDao;
import com.nrvcer.domain.Student;
import com.nrvcer.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private StudentDao studentDao = MyBatisUtil.getSqlSession().getMapper(StudentDao.class);
    @Test
    public void DynamicProxyTest02() {
        // PageHelpe分页使用示例
        // 获取第一页，2条内容（记录）
        PageHelper.startPage(1, 2);
        List<Student> students = studentDao.selectStudentsByField("name", "老刘");
        for (Student student : students) {
            System.out.println(student);
        }
    }
//    @Test
    // 测试MyBatis结合映射文件自动生成的动态代理对象执行SQL语句
    public void DynamicProxyTest01() {
        // 查询
        List<Student> studentList = studentDao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        Student student = new Student(2, "老刘", "110", 30);
        int rows = studentDao.insertStudent(student);
        System.out.println(rows);

    }
        @Test
    // MyBatisUtil工具类使用的测试
    public void myBatisUtilTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<Student> students = sqlSession.selectList("com.nrvcer.dao.StudentDao.selectStudents");
        for (Student student : students) {
            System.out.println(student);
        }
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void selectTest() throws IOException {
        // mybatis主配置文件
        String config = "mybatis.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 创建SqlSessionFactory对象，目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession，该类的对象能够执行SQL语句
        SqlSession sqlSession = factory.openSession();
        // 执行SqlSession的selectList方法
        List<Student> students = sqlSession.selectList("com.nrvcer.dao.StudentDao.selectStudents");
        for (Student student : students) {
            System.out.println(student);
        }
        // 关闭SqlSession，释放资源
        sqlSession.close();
    }
    @Test
    public void insertTest() throws IOException {
        // mybatis主配置文件
        String config = "mybatis.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 创建SqlSessionFactory对象，目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession，该类的对象能够执行SQL语句
        SqlSession sqlSession = factory.openSession();
        // 创建保存数据的对象
        Student student = new Student(3, "王五", "1480034956@qq.com", 21);
        // 执行插入
        int rows = sqlSession.insert("com.nrvcer.dao.StudentDao.insertStudent", student);
        // 提交事务
        sqlSession.commit();
        System.out.println("数据库表中增加记录的行数："+rows);
        // 关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void updateTest() throws IOException {
        // mybatis主配置文件
        String config = "mybatis.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 创建SqlSessionFactory对象，目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession，该类的对象能够执行SQL语句
        SqlSession sqlSession = factory.openSession();
        // 创建保存数据的对象
        Student student = new Student();
        student.setId(1);
        student.setName("programmer");
        int rows = sqlSession.update("com.nrvcer.dao.StudentDao.updateStudent", student);
        // 提交事务
        sqlSession.commit();
        System.out.println("修改记录的行数："+ rows);
        // 关闭资源
        sqlSession.close();
    }
    @Test
    public void deleteTest() throws IOException {
        // mybatis主配置文件
        String config = "mybatis.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 创建SqlSessionFactory对象，目的是获取SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession，该类的对象能够执行SQL语句
        SqlSession sqlSession = factory.openSession();
        // 删除的id
        int id = 2;
        // 执行删除语句
        int rows = sqlSession.delete("com.nrvcer.dao.StudentDao.deleteStudent", id);
        // 提交事务
        sqlSession.commit();
        System.out.println("修改记录的行数："+ rows);
        // 关闭资源
        sqlSession.close();
    }
}
