package cn.SkyShadow.model;

/**
 * 省份信息
 */
public class province {
	/**
	 * ID
	 */
	private Long provinceId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 国家信息
	 */
	private country country;

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public country getCountry() {
		return country;
	}

	public void setCountry(country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "province [provinceId=" + provinceId + ", name=" + name
				+ ", country=" + country + "]";
	}

}