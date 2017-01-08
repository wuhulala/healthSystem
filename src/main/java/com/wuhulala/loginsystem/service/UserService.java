package com.wuhulala.loginsystem.service;

import com.wuhulala.loginsystem.dal.mapper.UserMapper;
import com.wuhulala.loginsystem.dal.model.User;
import com.wuhulala.loginsystem.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/5
 */
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public int register(User model) {
        if (userMapper.findByName(model.getName()) != null) {
            return 1;
        }
        String newPass = PasswordUtil.createPassword(model.getPassword());
        model.setPassword(newPass);
        userMapper.insert(model);
        return  model.getId() == null ? 2 : 3;
    }

    public User login(User model) {
        String newPass = PasswordUtil.createPassword(model.getPassword());
        model.setPassword(newPass);

        model = userMapper.login(model);

        if (null != model) {
            return model;
        }
        return null;
    }
}
