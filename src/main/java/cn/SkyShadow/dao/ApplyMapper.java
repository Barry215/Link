package cn.SkyShadow.dao;

import cn.SkyShadow.model.Apply;

/**
 * 申请数据处理
 * Created by RichardW on 9/13/2016.
 */
public interface ApplyMapper {
    int Create(Apply apply);
    int OverTime(Long applyId);
    int Remove(Long applyId);
    int Finish(Long applyId);
}
