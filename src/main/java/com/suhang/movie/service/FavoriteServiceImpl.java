package com.suhang.movie.service;

import static com.suhang.movie.util.CheckUtil.checkArgument;
import static com.suhang.movie.util.CheckUtil.checkState;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.suhang.movie.dao.FavoriteDao;
import com.suhang.movie.model.Favorite;
import com.suhang.movie.model.RespCode;

/**
 * @author hang.su
 * @since 2017-04-25 下午10:55
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteDao favoriteDao;

    @Override
    public void create(Favorite favorite) {
        checkArgument(favorite.getUserId() != null && favorite.getMovieId() != null, "user id and movie id cannot be null");
        int res = favoriteDao.create(favorite);
        checkState(res > 0, RespCode.FAILED_TO_UPDATE);
    }

    @Override
    public void delete(Favorite favorite) {
        checkArgument(favorite.getUserId() != null && favorite.getMovieId() != null, "user id and movie id cannot be null");
        int res = favoriteDao.delete(favorite);
        checkState(res > 0, RespCode.FAILED_TO_UPDATE);
    }

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return favoriteDao.findByUserId(userId);
    }

    @Override
    public List<Favorite> findByMovieId(Long movieId) {
        return favoriteDao.findByMovieId(movieId);
    }
}
