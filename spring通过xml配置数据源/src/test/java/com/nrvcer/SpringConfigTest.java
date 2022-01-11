package com.nrvcer;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SpringConfigTest {
    @Test
    // spring容器产生ComboPooledDataSource数据源对象
    public void c3p0SpringConfigTest() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource)app.getBean("comboDataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    // spring容器产生ComboPooledDataSource数据源对象
    public void druidSpringConfigTest() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = (DruidDataSource) app.getBean("druidDataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    // 手动创建C3p0数据源测试(加载properties配置文件形式)
    public void c3p0ConfigTest() throws PropertyVetoException, SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    // 手动创建C3p0数据源测试
    public void c3p0Test() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/secs");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        Connection connection = dataSource.getConnection();
        System.out.println(connection); //com.mchange.v2.c3p0.impl.NewProxyConnection@28eaa59a
        connection.close();
    }

    @Test
    // 手动创建Druid数据源测试(加载properties配置文件形式)
    public void driudConfigTest() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    // 手动创建Druid数据源测试
    public void druidTest() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/secs");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection); // com.mysql.cj.jdbc.ConnectionImpl@4034c28c
        connection.close();
    }
}
