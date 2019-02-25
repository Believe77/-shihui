package cn.van.service.impl;

import cn.van.dao.UserMapper;
import cn.van.entity.User;
import cn.van.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userDao;

    public void save(User user) {
        userDao.insert(user);
        System.out.println("save=================");
    }

    public User findUser(User user) {
        // TODO Auto-generated method stub
        return userDao.findUser(user);
    }

    public void regist(User user) {
        // TODO Auto-generated method stub
        userDao.addUser(user);
    }

}
