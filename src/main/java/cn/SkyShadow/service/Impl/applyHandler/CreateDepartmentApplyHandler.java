package cn.SkyShadow.service.Impl.applyHandler;

import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.applyChildren.CreateDepartment;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 创建部门的apply处理器
 * Created by Richard on 16/10/4.
 */
public class CreateDepartmentApplyHandler extends ApplyHandler<CreateDepartment>
{
    @Override
    public ResultMapper doSomeThing_FULL(CreateDepartment apply) {
        return null;
    }

    @Override
    public ResultMapper doSomeThing_APPLY_AVAILABLE(CreateDepartment apply) {
        return null;
    }
}
