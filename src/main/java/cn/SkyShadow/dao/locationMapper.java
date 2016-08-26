package cn.SkyShadow.dao;

import cn.SkyShadow.model.location;

public interface locationMapper {

    location selectByPrimaryKey(Long locationId);

    int CreateNewLocation(location location);
}