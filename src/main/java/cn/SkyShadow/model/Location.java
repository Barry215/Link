package cn.SkyShadow.model;

public class Location {
	private Long locationId;

	private City city;

	private String detail;

	private Float longitude;

	private Float latitude;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", City=" + city
				+ ", detail=" + detail + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}

}