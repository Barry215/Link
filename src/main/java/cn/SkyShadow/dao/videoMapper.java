package cn.SkyShadow.dao;

import cn.SkyShadow.model.video;

public interface videoMapper {
	/**
	 * 删除视频
	 * @param videoId 删除视频ID
	 * @return 执行结果
	 */
	int deleteByPrimaryKey(Long videoId);

	/**
	 * 新建视频
	 * @param record 视频
	 * @return 执行结果
	 */
	int insert(video record);

	/**
	 * 查询视频信息
	 * @param videoId 视频ID
	 * @return 执行结果
	 */
	video selectByPrimaryKey(Long videoId);

}