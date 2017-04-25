package com.suhang.movie.service;

import static com.suhang.movie.util.CheckUtil.checkArgument;
import static com.suhang.movie.util.CheckUtil.checkState;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.suhang.movie.dao.MovieDao;
import com.suhang.movie.model.Movie;
import com.suhang.movie.model.RespCode;

/**
 * @author hang.su
 * @since 2017-04-25 下午10:47
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieDao movieDao;

    @Override
    public void create(Movie movie) {
        checkArgument(StringUtils.isNotBlank(movie.getName()), "movie name cannot be blank");
        movieDao.create(movie);
    }

    @Override
    public void update(Movie movie) {
        checkArgument(movie.getName() != null || movie.getDescription() != null || movie.getStatus() != null, "movie name, description, status cannot be all null");
        if (movie.getName() != null) {
            checkArgument(StringUtils.isNotBlank(movie.getName()), "movie name cannot be blank");
        }
    }

    @Override
    public void delete(Movie movie) {
        checkArgument(movie.getId() != null, "movie id cannot be null");
        checkState(findById(movie.getId()) != null, RespCode.MOVIE_NOT_EXISTS);
        int res = movieDao.delete(movie.getId());
        checkState(res > 0, RespCode.FAILED_TO_UPDATE);
    }

    @Override
    public Movie findById(Long id) {
        return movieDao.findById(id);
    }
}
