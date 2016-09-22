package cn.SkyShadow.model.apply;

import cn.SkyShadow.model.User;

/**
 * Created by Richard on 16/8/31.
 * 申请
 */
public abstract class Apply {
    private Long id;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
