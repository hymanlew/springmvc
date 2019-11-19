package mvc.spring.service;

import mvc.spring.bean.User;
import mvc.spring.bean.UserInfo;
import mvc.spring.bean.UserVO;
import mvc.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 业务逻辑
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     * 新增用户
     * @param userInfo
     * @param user
     */
    public void save(UserInfo userInfo, User user){
        Object[] data = userDao.save(userInfo);
        //user.setUserInfoId(Long.valueOf(data[1].toString()));

        userDao.save(user);
    }

    public List<UserVO> testStream(){
        List<User> userList = userDao.findList();

        // flatMap，接收一个函数作为参数，将流中的每个值都换成一个流，然后把流连接成一个流。即扁平化为一个流。
        List<UserVO> data = userDao.findList(userList.stream().map(User::getName)
                .collect(Collectors.toList()))

                .stream().flatMap(y -> userList.stream().filter(x -> x.getName().equals(y.getRealName()))
                        .map(x-> new UserVO(x,y))
                ).collect(Collectors.toList());
        return data;
    }

    public List<UserVO> testStream1() {
        return userDao.findList().stream().map(x -> new UserVO(x, userDao.findById((long)x.getSalary()))).collect(Collectors.toList());
    }
}
