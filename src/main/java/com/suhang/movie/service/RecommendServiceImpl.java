package com.suhang.movie.service;

import static com.suhang.movie.util.CheckUtil.checkArgument;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.suhang.movie.dao.FavoriteDao;
import com.suhang.movie.dao.MovieDao;
import com.suhang.movie.model.Favorite;
import com.suhang.movie.model.Movie;

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
        checkArgument(userId != null && userId > 0L, "invalid user id");
        Set<Long> myMovieIds = favoriteDao.findByUserId(userId).stream()
            .map(Favorite::getMovieId)
            .collect(Collectors.toSet());
        Set<Long> otherMovieIds = myMovieIds.stream()
            .map(movieId -> favoriteDao.findByMovieId(movieId))
            .flatMap(Collection::stream)
            .map(userFav -> favoriteDao.findByUserId(userFav.getUserId()))
            .flatMap(Collection::stream)
            .map(Favorite::getMovieId)
            .collect(Collectors.toSet());
        Collection<Long> movieIds = CollectionUtils.subtract(otherMovieIds, CollectionUtils.intersection(otherMovieIds, myMovieIds));
        return movieIds.stream()
            .map(movieId -> movieDao.findById(movieId))
            .collect(Collectors.toList());
    }
}
