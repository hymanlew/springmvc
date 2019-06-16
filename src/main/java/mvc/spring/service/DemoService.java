package mvc.spring.service;

import mvc.spring.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    @Transactional
    public void insert(){
        demoDao.insert();
        System.out.println("插入数据成功 =====");

        int data = 10/0;
    }
}
