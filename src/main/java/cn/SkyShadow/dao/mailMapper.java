package cn.SkyShadow.dao;

import cn.SkyShadow.model.mail;

public interface mailMapper {
    /**
     * 删除邮件
     * @param mailId 邮件ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long mailId);

    /**
     * 新建邮件
     * @param record 邮件信息
     * @return 执行结果
     */
    int insertSelective(mail record);

    /**
     * 查询邮件
     * @param mailId 邮件ID
     * @return 邮件信息
     */
    mail selectByPrimaryKey(Long mailId);

}