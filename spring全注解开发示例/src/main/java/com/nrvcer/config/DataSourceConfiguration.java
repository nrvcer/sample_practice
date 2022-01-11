package com.nrvcer.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//<context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
// 加载properties文件中的配置
@PropertySource(value = "classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value(value="${jdbc.driver}")
    private String driver;
    @Value(value="${jdbc.url}")
    private String url;
    @Value(value="${jdbc.user}")
    private String username;
    @Value(value="${jdbc.passward}")
    private String password;

    // spring容器会将当前方法的返回值以指定名称存储到spring容器中
    @Bean(value = "dataSource")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
