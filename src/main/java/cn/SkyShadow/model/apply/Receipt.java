package cn.SkyShadow.model.apply;


public class Receipt<T extends Apply> {
    private T apply;
    private boolean success;
    private String reason;

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
}
