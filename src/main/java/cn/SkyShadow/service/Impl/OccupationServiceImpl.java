package cn.SkyShadow.service.Impl;

import cn.SkyShadow.model.Apply;
import cn.SkyShadow.model.Receipt;
import cn.SkyShadow.model.occupation;
import cn.SkyShadow.service.OccupationService;

/**
 * 职位管理器
 * Created by Richard on 16/9/13.
 */
public class OccupationServiceImpl implements OccupationService {
    @Override
    public Exception CreateOccupation(occupation occupation) {
        return null;
    }

    @Override
    public Exception DeleteOccupation(Long occupationId) {
        return null;
    }

    @Override
    public Exception ModifyOccupation(occupation occupation) {
        return null;
    }

    @Override
    public Exception ModifyOccupation_Power(occupation occupation) {
        return null;
    }

    @Override
    public Exception AddUserToOccupation(Apply apply) {
        return null;
    }

    @Override
    public Exception RollBackAddUserToOccupation(Long ApplyId) {
        return null;
    }

    @Override
    public Exception AddUserToOccupationCallBcak(Receipt receipt) {
        return null;
    }

    @Override
    public Exception RemoveUser(Long userId, Long occuId) {
        return null;
    }
}
