package cn.SkyShadow.service.Impl;

import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.service.ReceiptHandler;

import java.util.List;

/**
 * 请求处理器
 * Created by RichardW on 9/25/2016.
 */
public class ReceiptHandlerImpl<T extends Apply> implements ReceiptHandler {
    @Override
    public List getAllApply(Long userId) {
        return null;
    }

    @Override
    public void agree(Long ApplyId) {

    }

    @Override
    public void disAgree(Long ApplyId, String reason) {

    }
}
