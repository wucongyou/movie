package com.suhang.movie.dao;

import java.util.List;

import com.suhang.movie.model.Favorite;

/**
 * @author hang.su
 * @since 2017-04-25 下午10:20
 */
public interface FavoriteDao {

    int create(Favorite favorite);

    int delete(Favorite favorite);

    List<Favorite> findByUserId(Long userId);

    List<Favorite> findByMovieId(Long movieId);

}
