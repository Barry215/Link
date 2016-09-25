package cn.SkyShadow.service;

import cn.SkyShadow.model.apply.Apply;

import java.util.List;

/**
 * 请求处理器
 * Created by RichardW on 9/25/2016.
 */
public interface ReceiptHandler<T extends Apply> {
    List<T> getAllApply(Long userId);
    void agree(Long ApplyId);
    void disAgree(Long ApplyId,String reason);
}
