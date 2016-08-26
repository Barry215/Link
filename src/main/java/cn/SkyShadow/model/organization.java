package cn.SkyShadow.model;

import java.util.List;

public class organization {
	private Long orgId;

	private String name;

	private location location;

	private organization parentId;

	private user creatorId;

	private List<announce> announces;

	private List<organization> sonOrganizations;

	public organization(String name, cn.SkyShadow.model.location location,
			organization parentId, user creatorId) {
		super();
		this.name = name;
		this.location = location;
		this.parentId = parentId;
		this.creatorId = creatorId;
	}

	public organization() {
		super();
	}

	public List<organization> getSonOrganizations() {
		return sonOrganizations;
	}

	public void setSonOrganizations(List<organization> sonOrganizations) {
		this.sonOrganizations = sonOrganizations;
	}

	public List<announce> getAnnounces() {
		return announces;
	}

	public void setAnnounces(List<announce> announces) {
		this.announces = announces;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public location getLocation() {
		return location;
	}

	public void setLocation(location location) {
		this.location = location;
	}

	public organization getParentId() {
		return parentId;
	}

	public void setParentId(organization parentId) {
		this.parentId = parentId;
	}

	public user getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(user creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "organization [orgId=" + orgId + ", name=" + name
				+ ", location=" + location + ", parentId=" + parentId
				+ ", creatorId=" + creatorId + ", announces=" + announces
				+ ", sonOrganizations=" + sonOrganizations + "]";
	}

}