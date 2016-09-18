package cn.SkyShadow.dto.user;

import java.util.Date;

/**
 * 密保验证key
 * Created by RichardW on 8/25/2016.
 */
public class PasswordProtectedKey {
    private Date createDate = new Date();

    public Date getCreateDate() {
        return createDate;
    }
}
