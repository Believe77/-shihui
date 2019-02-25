package cn.van.service;

import cn.van.entity.User;

public interface TestService {

    void save(User user);

    void regist(User user);

    User findUser(User user);
}
