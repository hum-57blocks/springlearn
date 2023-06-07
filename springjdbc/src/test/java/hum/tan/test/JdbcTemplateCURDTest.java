package hum.tan.test;

import hum.tan.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCURDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        int rows = jdbcTemplate.update("update `account` set `money`=? where `username`=?", 200, "jolin");
        System.out.println(rows);
    }

    @Test
    public void testDelete() {
        int rows = jdbcTemplate.update("delete from `account` where `username`=?", "jolin");
        System.out.println(rows);
    }

    @Test
    public void testQueryAll() {
        List<Account> accounts = jdbcTemplate.query("select * from `account`", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accounts);
    }

    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("select * from `account` where `username`=?", new BeanPropertyRowMapper<>(Account.class), "hum");
        System.out.println(account);
    }

    @Test
    public void testQueryCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from `account`", Long.class);
        System.out.println(count);
    }

}
