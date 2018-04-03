package com.suhang.movie.model;

import java.io.Serializable;

/**
 * @author hang.su
 * @since 2018-04-03 下午12:02
 */
public class Album implements Serializable {

    private Long id;

    private String name;

    private String desc;

    private Integer status;

    private Long ctime;

    private Long mtime;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private String name;
        private String desc;
        private Integer status;
        private Long ctime;
        private Long mtime;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder ctime(Long ctime) {
            this.ctime = ctime;
            return this;
        }

        public Builder mtime(Long mtime) {
            this.mtime = mtime;
            return this;
        }

        public Album build() {
            Album a = new Album();
            a.setId(id);
            a.setName(name);
            a.setDesc(desc);
            a.setStatus(status);
            a.setCtime(ctime);
            a.setMtime(mtime);
            return a;
        }
    }

    @Override
    public String toString() {
        return "Album{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", desc='" + desc + '\'' +
            ", status=" + status +
            ", ctime=" + ctime +
            ", mtime=" + mtime +
            '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }
}
