package com.suhang.movie.service;

import static com.suhang.movie.util.CheckUtil.checkArgument;
import static com.suhang.movie.util.CheckUtil.checkState;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suhang.movie.dao.UserDao;
import com.suhang.movie.model.RespCode;
import com.suhang.movie.model.User;

/**
 * @author hang.su
 * @since 2017-04-25 下午8:54
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private PasswordService passwordService;


    @Override
    public void create(User user) {
        checkArgument(user.getUsername() != null, "username cannot be null");
        checkArgument(user.getPassword() != null, "password cannot be null");
        // TODO improve username validation check
        checkState(findByUsername(user.getUsername()) == null, RespCode.USERNAME_ALREADY_EXISTS);
        passwordService.encryptPassword(user);
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        checkArgument(user.getId() != null || user.getUsername() != null, "uid or username cannot be both null");
        if (user.getId() != null) {
            checkState(findById(user.getId()) != null, RespCode.USER_NOT_EXISTS);
        } else {
            User u = findByUsername(user.getUsername());
            checkState(u != null, RespCode.USER_NOT_EXISTS);
            user.setId(u.getId());
        }
        checkArgument(user.getPassword() != null || user.getStatus() != null, "nothing to update, now supports status and password update");
        checkArgument(user.statusValid(), "invalid user status");
        if (user.getPassword() != null) {
            // TODO check password validation
            passwordService.encryptPassword(user);
        }
        userDao.update(user);
    }

    @Override
    public void delete(Long uid) {
        checkState(findById(uid) != null, RespCode.USER_NOT_EXISTS);
        userDao.delete(uid);
    }

    @Override
    public void delete(String username) {
        User user = findByUsername(username);
        checkState(user != null, RespCode.USER_NOT_EXISTS);
        userDao.delete(user.getId());
    }

    @Override
    public User findById(Long uid) {
        return userDao.findById(uid);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
