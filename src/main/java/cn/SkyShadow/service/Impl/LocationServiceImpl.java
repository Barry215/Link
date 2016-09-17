package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dto.factory.ExcutionFactory;
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
    public Execution Add(location location) {
        return ExcutionFactory.GetExcutionByResultCode(locationMapper.CreateNewLocation(location));
    }

    @Override
    public Execution Remove(Long locationId) {
        return ExcutionFactory.GetExcutionByResultCode(locationMapper.RemoveLocation(locationId));
    }

    @Override
    public Execution Modify(location location) {
        return ExcutionFactory.GetExcutionByResultCode(locationMapper.Modifylocation(location));
    }
}
