package cn.SkyShadow.dao;

import cn.SkyShadow.model.Video;

public interface VideoMapper {
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
	int insert(Video record);

	/**
	 * 查询视频信息
	 * @param videoId 视频ID
	 * @return 执行结果
	 */
	Video selectByPrimaryKey(Long videoId);

}