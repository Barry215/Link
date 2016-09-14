package cn.SkyShadow.model;

/**
 * Created by Richard on 16/8/31.
 * 申请
 */
public class Apply {
    private Long id;
    private user A;
    private user B;
    private Object objectA;
    private Object objectB;
    private String state;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public user getA() {
        return A;
    }

    public void setA(user a) {
        A = a;
    }

    public user getB() {
        return B;
    }

    public void setB(user b) {
        B = b;
    }

    public Object getObjectA() {
        return objectA;
    }

    public void setObjectA(Object objectA) {
        this.objectA = objectA;
    }

    public Object getObjectB() {
        return objectB;
    }

    public void setObjectB(Object objectB) {
        this.objectB = objectB;
    }

    public Apply(String key) {
        this.key = key;
    }

    public Apply() {
    }
}
