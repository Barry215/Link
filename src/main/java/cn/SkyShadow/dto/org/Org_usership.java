package cn.SkyShadow.dto.org;

public class Org_usership {
    private boolean isRoot = false;
    private boolean isManager = false;

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
