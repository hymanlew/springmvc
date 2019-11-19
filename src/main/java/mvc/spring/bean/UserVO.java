package mvc.spring.bean;

public class UserVO {

    private User user;
    private UserInfo userInfo;

    public UserVO(User user, UserInfo userInfo) {
        this.user = user;
        this.userInfo = userInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
