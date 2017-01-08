package com.wuhulala.loginsystem.service;

import com.wuhulala.loginsystem.dal.mapper.AccountMapper;
import com.wuhulala.loginsystem.dal.model.Account;
import com.wuhulala.loginsystem.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/12/25
 */
@Service
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    public Account login(String name, String password) {
        String newPass = PasswordUtil.createPassword(password);
        Account account = new Account(name, newPass);

        account = accountMapper.login(account);

        if (null != account) {
            account.setLastLogin(new Date());
            accountMapper.updateLastLogin(account);
            return account;
        }
        return null;

    }

    /**
     * 注册
     *
     * @return
     * 1 用户名已存在
     * 2 数据库错误
     * 3 注册成功
     */
    @Transactional
    public int register(String name, String password) {
        if (accountMapper.findByName(name) != null) {
            return 1;
        }
        String newPass = PasswordUtil.createPassword(password);
        Account account = new Account(name, newPass);
        accountMapper.insert(account);
        return  account.getId() == null ? 2 : 3;
    }

    /**
     * 修改密码
     *
     * @return
     * 0 用户不存在
     * 1 原密码错误
     * 2 修改成功
     */
    @Transactional
    public int editPassword(Long id, String password, String newPassword) {

        Account account = accountMapper.findById(id);
        if (null != account) {
            if(PasswordUtil.authenticatePassword(account.getPassword(),password)) return 1;
            account.setPassword(PasswordUtil.createPassword(newPassword));
            accountMapper.updatePassword(account);
            return 2;
        }
        return 0;
    }
}
