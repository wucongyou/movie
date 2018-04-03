package com.suhang.movie.dao.impl;

import org.springframework.stereotype.Repository;

import com.suhang.movie.dao.AlbumCacheDao;
import com.suhang.movie.model.Album;
import com.suhang.movie.model.BinaryStatus;

/**
 * @author hang.su
 * @since 2018-04-03 下午12:23
 */
@Repository
public class AlbumCacheDaoImpl implements AlbumCacheDao {

    @Override
    public Album get(long id) {
        return Album.builder()
            .id(id)
            .name("Album_" + id)
            .desc("mocked album for cache")
            .status(BinaryStatus.OK.code)
            .ctime(System.currentTimeMillis() / 1000L)
            .mtime(System.currentTimeMillis() / 1000L)
            .build();
    }
}
