package cn.SkyShadow.model;

public class School {
	private Long schoolId;

	private String name;

	private Location location;

	private String rank;

	private School parentId;

	private String isPublic;

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public School getParentId() {
		return parentId;
	}

	public void setParentId(School parentId) {
		this.parentId = parentId;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic == null ? null : isPublic.trim();
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name
				+ ", Location=" + location + ", rank=" + rank + ", parentId="
				+ parentId + ", isPublic=" + isPublic + "]";
	}

}