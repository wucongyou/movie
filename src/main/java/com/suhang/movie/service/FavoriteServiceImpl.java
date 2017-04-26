package com.suhang.movie.service;

import static com.suhang.movie.util.CheckUtil.checkArgument;
import static com.suhang.movie.util.CheckUtil.checkState;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suhang.movie.dao.FavoriteDao;
import com.suhang.movie.dao.MovieDao;
import com.suhang.movie.model.Favorite;
import com.suhang.movie.model.FavoriteQuery;
import com.suhang.movie.model.RespCode;

/**
 * @author hang.su
 * @since 2017-04-25 下午10:55
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteDao favoriteDao;

    @Resource
    private MovieDao movieDao;

    @Override
    public void create(Favorite favorite) {
        checkArgument(favorite.getUserId() != null && favorite.getMovieId() != null, "user id and movie id cannot be null");
        checkState(movieDao.findById(favorite.getMovieId()) != null, RespCode.MOVIE_NOT_EXISTS);
        int res = favoriteDao.create(favorite);
        checkState(res > 0, RespCode.FAILED_TO_UPDATE);
    }

    @Override
    public void delete(Favorite favorite) {
        checkArgument(favorite.getUserId() != null && favorite.getMovieId() != null, "user id and movie id cannot be null");
        checkState(favoriteDao.findById(favorite) != null, RespCode.MOVIE_NOT_IN_FAVORITES);
        int res = favoriteDao.delete(favorite);
        checkState(res > 0, RespCode.FAILED_TO_UPDATE);
    }

    @Override
    public Favorite findById(Favorite favorite) {
        checkArgument(favorite.getUserId() != null && favorite.getMovieId() != null, "user id and movie id cannot be null");
        return favoriteDao.findById(favorite);
    }

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return favoriteDao.findByUserId(userId);
    }

    @Override
    public List<Favorite> findByMovieId(Long movieId) {
        return favoriteDao.findByMovieId(movieId);
    }

    @Override
    public List<Favorite> query(FavoriteQuery query) {
        checkArgument(query.getLastId() != null && query.getLastId() >= 0L, "last id cannot be null or negative");
        checkArgument(query.getLimit() != null, "limit cannot be null");
        checkArgument(query.getUserId() != null || query.getMovieId() != null, "user id and movie id cannot be both null");
        checkArgument(query.getUserId() == null || query.getMovieId() == null, "user id and movie id cannot be both non null");
        return favoriteDao.query(query);
    }
}
