import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    // 测试使用Spring XML配置的JdbcTemplate开发步骤
    public void xmlConfigTest() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?, ?)", "李四", 200);
        System.out.println(row);
    }
    @Test
    // 测试JdbcTemplate开发步骤
    public void pureTest() {
        // 创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/clerk");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into account values(?,?)", "张三", 100);
        System.out.println(row);    // 1
    }

}
