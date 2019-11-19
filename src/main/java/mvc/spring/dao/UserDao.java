package mvc.spring.dao;

import mvc.spring.bean.User;
import mvc.spring.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author niaoshuai
 */
@Component
public class UserDao {

    @Autowired
    private JdbcTemplate template;

    /**
     * 查询所有的用户
     * @return
     */
    public List<User> findList(){
        return template.query("select id,username,user_info_id,gmt_create,gmt_modified from user limit 10",
                (rs, rowNum) -> {
            User user = new User();
            user.setName(rs.getString("username"));
            user.setPassword(rs.getString("user_info_id"));
            user.setSalary(rs.getInt("gmt_create"));

            //user.setPassword(rs.getLong(""));
            //user.setGmtModified(rs.getDate("gmt_modified"));
            return user;
        });
    }

    /**
     * 新增
     * @param user
     */
    public int save(User user){
        return template.update("insert into user(username,password,user_info_id) values(?,?,?)",
                new Object[]{user.getName(),user.getPassword(),user.getSalary()});
    }

    /**
     * 新增
     * @param userInfo
     */
    public Object[] save(UserInfo userInfo){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement("insert into user_info(real_name,hobby) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,userInfo.getRealName());
            ps.setString(2,userInfo.getHobby());
            return ps;
        };
        int rows = template.update(preparedStatementCreator,keyHolder);
        return new Object[]{rows, keyHolder.getKey().longValue()};
    }


    public List<UserInfo> findList(List<String> ids){
        // ids 实际的值是 long 值。
        return template.query("select * from user_info where id in (?)",ids.toArray(), (rs, rowNum) -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(rs.getLong("id"));
            userInfo.setHobby(rs.getString("hobby"));
            userInfo.setRealName(rs.getString("real_name"));
            userInfo.setGmtCreate(rs.getDate("gmt_create"));
            userInfo.setGmtModified(rs.getDate("gmt_modified"));
            return userInfo;
        });
    }

    public UserInfo findById(Long id){
        return template.queryForObject("select * from user_info where id = " + id, (rs, rowNum) -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(rs.getLong("id"));
            userInfo.setHobby(rs.getString("hobby"));
            userInfo.setRealName(rs.getString("real_name"));
            userInfo.setGmtCreate(rs.getDate("gmt_create"));
            userInfo.setGmtModified(rs.getDate("gmt_modified"));
            return userInfo;
        });
    }

    /**
     * 关联查询 方式1
     */
    public void findList1(){
        StringBuffer sql = new StringBuffer();
        sql.append(" select u.id,u.username,ui.hobby")
                .append(" from user u")
                .append(" inner join user_info ui")
                .append(" ui.user_id = u.id");

        template.query("select id from user u inner join ", new RowMapper<Map<String,Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map<String,Object> item1 = new HashMap<>();
                item1.put("id",rs.getLong("id"));
                item1.put("username",rs.getString("username"));
                item1.put("hobby",rs.getString("hobby"));
                return item1;
            }
        });
    }

    /**
     * 关联查询 方式2 JDK8 写法
     */
    public List<Map<String,Object>> findList2(){
        StringBuffer sql = new StringBuffer();
        sql.append(" select u.id,u.username,ui.hobby")
                .append(" from user u")
                .append(" inner join user_info ui")
                .append(" on ui.id = u.user_info_id")
                .append(" limit 1,10");

        return template.query(sql.toString(), (rs, rowNum) -> {
            Map<String,Object> item2 = new HashMap<>();
            item2.put("id",rs.getLong("id"));
            item2.put("username",rs.getString("username"));
            item2.put("hobby",rs.getString("hobby"));
            return item2;
        });
    }


    /**
     * 查询所有的用户
     * @return
     */
    public List<User> findList3(){
        return template.query("select id,username,password,gmt_create,gmt_modified from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setName(rs.getString("username"));
                return user;
            }
        });
    }

    /**
     * 关联查询 方式2 JDK8 集合合并  找UserServiceSupport.java
     */
}
