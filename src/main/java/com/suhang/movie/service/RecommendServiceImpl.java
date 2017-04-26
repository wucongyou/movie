package com.suhang.movie.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suhang.movie.dao.FavoriteDao;
import com.suhang.movie.dao.MovieDao;
import com.suhang.movie.model.Movie;
import com.suhang.movie.util.CheckUtil;

/**
 * @author hang.su
 * @since 2017-04-26 上午11:45
 */
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

    @Resource
    private FavoriteDao favoriteDao;

    @Resource
    private MovieDao movieDao;

    @Override
    public List<Movie> recommend(Long userId) {
        CheckUtil.checkArgument(userId != null && userId > 0L, "invalid user id");
        List<Movie> movies = favoriteDao.findByUserId(userId).stream()
            .map(movieFav -> favoriteDao.findByMovieId(movieFav.getMovieId()))
            .flatMap(Collection::stream)
            .map(userFav -> favoriteDao.findByUserId(userFav.getUserId()))
            .flatMap(Collection::stream)
            .map(movieFav -> movieDao.findById(movieFav.getMovieId()))
            .collect(Collectors.toList());
        return movies;
    }
}
