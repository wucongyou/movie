package com.suhang.movie.service;

import com.suhang.movie.model.User;

/**
 * @author hang.su
 * @since 2017-04-25 下午8:56
 */
public interface PasswordService {

    void encryptPassword(User user);

    boolean passwordMatches(String plaintext, User user);
}
