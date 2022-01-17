package com.nrvcer.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    // SqlSessionFactory类型的对象,创建该对象耗时长，占用资源多，整个项目中有一个就够用了
    private static SqlSessionFactory factory = null;

    // 使用静态代码块创建一次SqlSessionFactory
    static {
        String config = "mybatis.xml";

        try {
            // Resource负责读取配置文件
            InputStream in = Resources.getResourceAsStream(config);
            factory =  new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            factory = null;
            e.printStackTrace();
        }
    }

    //获取SqlSession对象的方法
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            // 参数可以设置是否自动提交事务
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}
