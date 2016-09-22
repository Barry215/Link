package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.Announce;
import cn.SkyShadow.dao.AnnounceMapper;
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
    private final AnnounceMapper AnnounceMapper;
    @Autowired(required = false)
    public AnnounceServiceImpl(AnnounceMapper AnnounceMapper) {
        this.AnnounceMapper = AnnounceMapper;
    }

    @Override
    public BaseExecution Announce(Announce a, Long organizationID) {
        return ExecutionFactory.getExecutionByResultCode(AnnounceMapper.insert(a,organizationID));
    }

    @Override
    public BaseExecution DeleteAnnounce(Long annId) {
        return ExecutionFactory.getExecutionByResultCode(AnnounceMapper.deleteByPrimaryKey(annId));
    }

    @Override
    public List<Announce> SelectAnnListByOrgId(Long orgId) {
        return AnnounceMapper.selectByOrganizationId(orgId);
    }
}
