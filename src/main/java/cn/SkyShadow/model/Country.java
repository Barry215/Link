package cn.SkyShadow.model;

/**
 * 国家
 */
public class Country {
	/**
	 * 国家ID
	 */
	private Long countryId;
	/**
	 * 中文名
	 */
	private String nameCn;
	/**
	 * 日文名
	 */
	private String nameJp;
	/**
	 * 英文名
	 */
	private String nameUs;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn == null ? null : nameCn.trim();
	}

	public String getNameJp() {
		return nameJp;
	}

	public void setNameJp(String nameJp) {
		this.nameJp = nameJp == null ? null : nameJp.trim();
	}

	public String getNameUs() {
		return nameUs;
	}

	public void setNameUs(String nameUs) {
		this.nameUs = nameUs == null ? null : nameUs.trim();
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", nameCn=" + nameCn
				+ ", nameJp=" + nameJp + ", nameUs=" + nameUs + "]";
	}

}