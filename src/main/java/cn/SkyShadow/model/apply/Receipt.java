package cn.SkyShadow.model.apply;


import cn.SkyShadow.basic_component.JsonFormatUtil;
import cn.SkyShadow.model.User;

public class Receipt<T extends Apply> {
    private Long id;
    private T apply;
    private boolean success;
    private String agree;
    private String reason;
    private User user;

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
        success = agree.equals("Y");
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JsonFormatUtil.getJsonFormatString(this);
    }
}
