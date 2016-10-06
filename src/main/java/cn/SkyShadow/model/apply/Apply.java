package cn.SkyShadow.model.apply;

import cn.SkyShadow.model.User;

/**
 * Created by Richard on 16/8/31.
 * 申请
 */
public abstract class Apply {
    private Long id;
    private User user;

    public final Long getId() {
        return id;
    }

    public final void setId(Long id) {
        this.id = id;
    }

    public final User getUser() {
        return user;
    }

    public final void setUser(User user) {
        this.user = user;
    }

}
