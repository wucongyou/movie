package com.suhang.movie.dao;

import com.suhang.movie.model.Album;

/**
 * @author hang.su
 * @since 2018-04-03 下午12:20
 */
public interface AlbumCacheDao {

    Album get(long id);
}
