package cn.SkyShadow.basic_component;

import cn.SkyShadow.dto.org.OrgCertificate;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

/**
 * 证件处理
 * Created by Richard on 16/9/19.
 */
public interface CertificateHandller {
    /**
     * 获取组织的证件
     * @param user 用户信息
     * @param organization 组织信息
     * @return 执行结果
     */
    OrgCertificate getOrgCertificate(user user, organization organization);
}
