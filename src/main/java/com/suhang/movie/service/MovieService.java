package com.suhang.movie.service;

import com.suhang.movie.model.Movie;

/**
 * @author hang.su
 * @since 2017-04-25 下午10:42
 */
public interface MovieService {

    void create(Movie movie);

    void update(Movie movie);

    void delete(Movie movie);

    Movie findById(Long id);
}
