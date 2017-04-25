package com.suhang.movie.service;

import java.util.List;

import com.suhang.movie.model.Favorite;

/**
 * @author hang.su
 * @since 2017-04-25 下午10:43
 */
public interface FavoriteService {

    void create(Favorite favorite);

    void delete(Favorite favorite);

    List<Favorite> findByUserId(Long userId);

    List<Favorite> findByMovieId(Long movieId);
}
