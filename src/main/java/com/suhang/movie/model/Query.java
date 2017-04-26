package com.suhang.movie.model;

import java.io.Serializable;

/**
 * @author hang.su
 * @since 2017-04-26 上午9:49
 */
public class Query implements Serializable {

    private static final long serialVersionUID = -1806605805704730149L;

    private Long lastId;
    private Integer limit;

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
