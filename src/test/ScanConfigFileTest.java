import mvc.spring.bean.User;
import mvc.spring.bean.UserInfo;
import mvc.spring.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

// @ContextConfiguration 配上 spring的配置文件，就可以在测试类中使用注解简单的注入需要的bean了。简单高效。
@ContextConfiguration(locations = "classpath:ctxe.xml")
public class ScanConfigFileTest extends AbstractTestNGSpringContextTests {

    @Autowired
    UserService userService;

    @Test
    public void testSave() {
        userService.save(new UserInfo(), new User());
    }
}