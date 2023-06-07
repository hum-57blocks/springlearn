package hum.tan.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    // 测试JdbcTemplate开发步骤
    @Test
    public void test1() {
        // 创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springlearn");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源对象
        jdbcTemplate.setDataSource(dataSource);

        //执行操作
        int row = jdbcTemplate.update("insert into account values (?, ?)", "hum", 12.5);
        System.out.println(row);
    }
}
