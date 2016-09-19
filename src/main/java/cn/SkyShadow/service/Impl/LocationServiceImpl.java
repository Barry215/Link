package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.factory.ExecutionFactory;
import cn.SkyShadow.model.location;
import cn.SkyShadow.service.LocationService;
import cn.SkyShadow.dao.locationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 地点管理器
 * Created by RichardW on 9/13/2016.
 */
@Transactional
@Service
public class LocationServiceImpl implements LocationService {
    private final locationMapper locationMapper;
    @Autowired(required = false)
    public LocationServiceImpl(cn.SkyShadow.dao.locationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    @Override
    public BaseExecution Add(location location) {
        return ExecutionFactory.GetExcutionByResultCode(locationMapper.CreateNewLocation(location));
    }

    @Override
    public BaseExecution Remove(Long locationId) {
        return ExecutionFactory.GetExcutionByResultCode(locationMapper.RemoveLocation(locationId));
    }

    @Override
    public BaseExecution Modify(location location) {
        return ExecutionFactory.GetExcutionByResultCode(locationMapper.Modifylocation(location));
    }
}
