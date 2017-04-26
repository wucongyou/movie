package com.suhang.movie.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.suhang.movie.BaseTestContext;
import com.suhang.movie.model.User;

/**
 * @author hang.su
 * @since 2017-04-25 下午8:52
 */
public class UserDaoTest extends BaseTestContext {

    @Resource
    private UserDao userDao;

    @Test
    public void create() throws Exception {
        for (int i = 0; i < 2; i++) {
            User user = mockUser();
            userDao.create(user);
            Assert.assertNotNull(user.getId());
            System.out.println(user);
        }
    }

    @Test
    public void update() throws Exception {
        int res = userDao.update(User.builder()
            .id(1L)
            .password(mockStr(64))
            .salt(mockStr(32))
            .build());
        assertTrue(res > 0);
    }

    @Test
    public void delete() throws Exception {
        int res = userDao.delete(1L);
        assertTrue(res > 0);
    }

    @Test
    public void findByUid() throws Exception {
        User user = userDao.findById(1L);
        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void findByUsername() throws Exception {
        User user = userDao.findByUsername("hang.su");
        assertNotNull(user);
        System.out.println(user);
    }
}

