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
    public AnnounceServiceImpl(AnnounceMapper AnnounceMapper) {
        this.AnnounceMapper = AnnounceMapper;
    }

    }
