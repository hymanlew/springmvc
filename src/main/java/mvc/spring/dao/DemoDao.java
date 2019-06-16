package mvc.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into user(name, password) values(?, ?)";
        String name = UUID.randomUUID().toString().substring(0, 5);

        jdbcTemplate.update(sql, name, 20);
    }
}
