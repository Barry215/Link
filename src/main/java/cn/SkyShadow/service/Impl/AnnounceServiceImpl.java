package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.factory.ExecutionFactory;
import cn.SkyShadow.model.announce;
import cn.SkyShadow.dao.announceMapper;
import cn.SkyShadow.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 公告管理器
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class AnnounceServiceImpl implements AnnounceService {
    private final announceMapper announceMapper;
    @Autowired(required = false)
    public AnnounceServiceImpl(cn.SkyShadow.dao.announceMapper announceMapper) {
        this.announceMapper = announceMapper;
    }

    @Override
    public BaseExecution Announce(announce a, Long organizationID) {
        return ExecutionFactory.GetExcutionByResultCode(announceMapper.insert(a,organizationID));
    }

    @Override
    public BaseExecution DeleteAnnounce(Long annId) {
        return ExecutionFactory.GetExcutionByResultCode(announceMapper.deleteByPrimaryKey(annId));
    }

    @Override
    public List<announce> SelectAnnListByOrgId(Long orgId) {
        return announceMapper.selectByOrganizationId(orgId);
    }
}
