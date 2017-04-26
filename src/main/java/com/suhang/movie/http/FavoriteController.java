package com.suhang.movie.http;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suhang.movie.model.Favorite;
import com.suhang.movie.model.FavoriteQuery;
import com.suhang.movie.model.Resp;
import com.suhang.movie.service.FavoriteService;
import com.suhang.movie.util.LoginUtil;

/**
 * @author hang.su
 * @since 2017-04-26 上午10:12
 */
@Controller
@RequestMapping(value = "/favorite/", produces = "application/json")
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Resp add(@RequestParam("movie_id") Long movieId) {
        Long userId = LoginUtil.getLoginUserId();
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setMovieId(movieId);
        favoriteService.create(favorite);
        return Resp.OK;
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    @ResponseBody
    public Resp remove(@RequestParam("movie_id") Long movieId) {
        Long userId = LoginUtil.getLoginUserId();
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setMovieId(movieId);
        favoriteService.delete(favorite);
        return Resp.OK;
    }

    @RequestMapping(value = "favorites")
    @ResponseBody
    public Resp favorites(@RequestParam("last_id") Long lastId, @RequestParam Integer limit) {
        Long userId = LoginUtil.getLoginUserId();
        FavoriteQuery query = new FavoriteQuery();
        query.setLastId(lastId);
        query.setLimit(limit);
        query.setUserId(userId);
        List<Favorite> favorites = favoriteService.query(query);
        return Resp.ok(favorites);
    }

    @RequestMapping(value = "collect", method = RequestMethod.GET)
    @ResponseBody
    public Resp collect(@RequestParam("movie_id") Long movieId, @RequestParam("last_id") Long lastId, @RequestParam Integer limit) {
        FavoriteQuery query = new FavoriteQuery();
        query.setLastId(lastId);
        query.setLimit(limit);
        query.setMovieId(movieId);
        List<Favorite> favorites = favoriteService.query(query);
        return Resp.ok(favorites);
    }

    @RequestMapping(value = "recommend", method = RequestMethod.GET)
    @ResponseBody
    public Resp recommend() {
        Long userId = LoginUtil.getLoginUserId();
        return Resp.OK;
    }
}
