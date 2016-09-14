package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.factory.ExcutionFactory;
import cn.SkyShadow.model.announce;
import cn.SkyShadow.dao.announceMapper;
import cn.SkyShadow.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 公告管理器
 * Created by Richard on 16/9/13.
 */
public class AnnounceServiceImpl implements AnnounceService {
    private final announceMapper announceMapper;
    @Autowired
    public AnnounceServiceImpl(cn.SkyShadow.dao.announceMapper announceMapper) {
        this.announceMapper = announceMapper;
    }

    @Override
    public Excution Announce(announce a, Long organizationID) {
        return ExcutionFactory.GetExcutionByResultCode(announceMapper.insert(a,organizationID));
    }

    @Override
    public Excution DeleteAnnounce(Long annId) {
        return ExcutionFactory.GetExcutionByResultCode(announceMapper.deleteByPrimaryKey(annId));
    }

    @Override
    public List<announce> SelectAnnListByOrgId(Long orgId) {
        return announceMapper.selectByOrganizationId(orgId);
    }
}
