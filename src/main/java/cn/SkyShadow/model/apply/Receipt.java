package cn.SkyShadow.model.apply;


import cn.SkyShadow.model.User;

public class Receipt<T extends Apply> {
    private T apply;
    private boolean success;
    private String reason;
    private User user;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getApply() {
        return apply;
    }

    public void setApply(T apply) {
        this.apply = apply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
