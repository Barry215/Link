package cn.SkyShadow.model;

/**
 * 城市信息
 */
public class city {
	/**
	 * ID
	 */
	private Long cityId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类别
	 */
	private String rank;
	/**
	 * 所属省份
	 */
	private province province;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank == null ? null : rank.trim();
	}

	public province getProvince() {
		return province;
	}

	public void setProvince(province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "city [cityId=" + cityId + ", name=" + name + ", rank=" + rank
				+ ", province=" + province + "]";
	}

}