package cn.SkyShadow.model;

public class location {
	private Long locationId;

	private city city;

	private String detail;

	private Float longtitude;

	private Float latitude;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public city getCity() {
		return city;
	}

	public void setCity(city city) {
		this.city = city;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}

	public Float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Float longtitude) {
		this.longtitude = longtitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "location [locationId=" + locationId + ", city=" + city
				+ ", detail=" + detail + ", longtitude=" + longtitude
				+ ", latitude=" + latitude + "]";
	}

}