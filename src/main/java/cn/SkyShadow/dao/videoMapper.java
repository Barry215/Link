package cn.SkyShadow.dao;

import cn.SkyShadow.model.video;

public interface videoMapper {
	int deleteByPrimaryKey(Long videoId);

	int insert(video record);

	video selectByPrimaryKey(Long videoId);

}