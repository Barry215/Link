package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.factory.ExcutionFactory;
import cn.SkyShadow.model.location;
import cn.SkyShadow.service.LocationService;
import cn.SkyShadow.dao.locationMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 地点管理器
 * Created by RichardW on 9/13/2016.
 */
public class LocationServiceImpl implements LocationService {
    private final locationMapper locationMapper;
    @Autowired
    public LocationServiceImpl(cn.SkyShadow.dao.locationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    @Override
    public Excution Add(location location) {
        return ExcutionFactory.GetExcutionByResultCode(locationMapper.CreateNewLocation(location));
    }

    @Override
    public Excution Remove(Long locationId) {
        return ExcutionFactory.GetExcutionByResultCode(locationMapper.RemoveLocation(locationId));
    }

    @Override
    public Excution Modify(location location) {
        return ExcutionFactory.GetExcutionByResultCode(locationMapper.Modifylocation(location));
    }
}
