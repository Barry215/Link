package cn.SkyShadow.dao;

import cn.SkyShadow.model.mail;

import java.util.List;

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

    /**
     * 收取一个用户所有的邮件
     * @param userId 用户ID
     * @return 邮件列表
     */
    List<mail> Receive(Long userId);//TODO

    /**
     * 已读mail
     * @param mailIdList 邮件ID列表
     * @return 执行结果
     */
    int ReadMail(List<Long> mailIdList);//// TODO: 9/14/2016
}