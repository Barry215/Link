package cn.SkyShadow.model;

public class school {
	private Long schoolId;

	private String name;

	private location location;

	private String rank;

	private school parentId;

	private String ispublic;

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

	public location getLocation() {
		return location;
	}

	public void setLocation(location location) {
		this.location = location;
	}

	public school getParentId() {
		return parentId;
	}

	public void setParentId(school parentId) {
		this.parentId = parentId;
	}

	public String getIspublic() {
		return ispublic;
	}

	public void setIspublic(String ispublic) {
		this.ispublic = ispublic == null ? null : ispublic.trim();
	}

	@Override
	public String toString() {
		return "school [schoolId=" + schoolId + ", name=" + name
				+ ", location=" + location + ", rank=" + rank + ", parentId="
				+ parentId + ", ispublic=" + ispublic + "]";
	}

}