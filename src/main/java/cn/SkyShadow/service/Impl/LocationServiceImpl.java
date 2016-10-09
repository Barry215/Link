package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.Location;
import cn.SkyShadow.service.LocationService;
import cn.SkyShadow.dao.LocationMapper;
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
    private final LocationMapper LocationMapper;

    public LocationServiceImpl(LocationMapper LocationMapper) {
        this.LocationMapper = LocationMapper;
    }

    @Override
    public BaseExecution Add(Location location) {
        return null;
    }

    @Override
    public BaseExecution Remove(Long locationId) {
        return null;
    }

    @Override
    public BaseExecution Modify(Location location) {
        return null;
    }
}
