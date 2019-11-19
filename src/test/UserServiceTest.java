
import mvc.spring.bean.User;
import mvc.spring.bean.UserInfo;
import mvc.spring.bean.UserVO;
import mvc.spring.dao.UserDao;
import mvc.spring.service.UserService;
import mvc.spring.tx.TxConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = TxConfig.class)
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserService userService;

    @Test
    public void testTestStream() {
        List<UserVO> data = userService.testStream();
        Assert.assertNotNull("not null",data);

        Assert.assertNotNull(data);
        Assert.assertTrue(data.size()>0);
        Assert.assertEquals(data.get(0).getUser().getName(),"FFX");
        Assert.assertEquals(data.get(0).getUserInfo().getRealName(),"FFX");
    }

    @Test
    public void testTestStream1() {
        List<UserVO> data = userService.testStream1();
        Assert.assertNotNull(data);
        Assert.assertTrue(data.size()>0);
        Assert.assertEquals(data.get(0).getUser().getName(),"FFX");
        Assert.assertEquals(data.get(0).getUserInfo().getRealName(),"FFX");
    }

    @Autowired
    UserDao userDao;

    /**
     * junit 单元测试事务会自动回滚。通过@Rollback(true)注解来实现，默认是true，事务会回滚，可以不写。false时事务不会回滚，数据会写到数据库中。
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        User user = new User();
        user.setName("user2");
        user.setPassword("123456");
        Assert.assertTrue(userDao.save(user) > 0);
    }

    @Test
    public void testFindList() {
        userDao.findList().forEach(userInfo ->
                System.out.println("user = " + userInfo)
        );
        Assert.assertTrue(userDao.findList().size() >= 0);
    }

    @Test
    public void testSave2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setRealName("code_real");
        userInfo.setHobby("code");
        userInfo.setGmtCreate(new Date());
        Object[] result = userDao.save(userInfo);
        Assert.assertTrue(result.length > 0);
        Assert.assertTrue(Long.valueOf(result[1].toString()) > 0);
    }

}
