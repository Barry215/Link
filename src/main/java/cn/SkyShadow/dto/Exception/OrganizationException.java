package cn.SkyShadow.dto.Exception;

/**
 * 组织创建时候的错误
 * Created by Richard on 16/9/18.
 */
public class OrganizationException extends RuntimeException{
    public OrganizationException(String message) {
        super(message);
    }
}
