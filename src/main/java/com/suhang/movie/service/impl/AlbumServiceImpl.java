package com.suhang.movie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suhang.movie.dao.AlbumCacheDao;
import com.suhang.movie.dao.AlbumDao;
import com.suhang.movie.model.Album;
import com.suhang.movie.service.AlbumService;

/**
 * @author hang.su
 * @since 2018-04-03 下午12:05
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Resource
    private AlbumDao albumDao;

    @Resource
    private AlbumCacheDao albumCacheDao;

    @Override
    public Album get(long id) {
        Album a = albumCacheDao.get(id);
        if (a != null) {
            return a;
        }
        return albumDao.get(id);
    }
}
