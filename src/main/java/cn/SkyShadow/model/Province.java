package cn.SkyShadow.model;

/**
 * 省份信息
 */
public class Province {
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
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", name=" + name
				+ ", Country=" + country + "]";
	}

}