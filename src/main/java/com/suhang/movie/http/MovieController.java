package com.suhang.movie.http;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suhang.movie.model.Movie;
import com.suhang.movie.model.Query;
import com.suhang.movie.model.Resp;
import com.suhang.movie.service.MovieService;

/**
 * @author hang.su
 * @since 2017-04-26 上午9:32
 */
@Controller
@RequestMapping(value = "/movie/", produces = "application/json")
public class MovieController {

    @Resource
    private MovieService movieService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public Resp create(@RequestParam String name, @RequestParam(value = "description", required = false) String description) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(description);
        movieService.create(movie);
        return Resp.OK;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Resp update(@RequestParam Long id, @RequestParam(required = false) String name, @RequestParam(value = "description", required = false) String description, @RequestParam(required = false) Integer status) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setName(name);
        movie.setDescription(description);
        movie.setStatus(status);
        movieService.update(movie);
        return Resp.OK;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Resp delete(@RequestParam Long id) {
        movieService.delete(id);
        return Resp.OK;
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public Resp info(@RequestParam Long id) {
        return Resp.ok(movieService.findById(id));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Resp list(@RequestParam("last_id") Long lastId, @RequestParam Integer limit) {
        Query query = new Query();
        query.setLastId(lastId);
        query.setLimit(limit);
        return Resp.ok(movieService.query(query));
    }
}
