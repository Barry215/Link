package cn.SkyShadow.model;

import cn.SkyShadow.basic_component.JsonFormatUtil;

import java.util.List;

public class Organization {
	private Long orgId;

	private String name;

	private Location location;

	private Organization parentId;

	private User creatorId;

	private List<Announce> Announces;

	private List<Organization> sonOrganizations;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Organization(String name, Location location,
						Organization parentId, User creatorId , String type) {
		super();
		this.name = name;
		this.location = location;
		this.parentId = parentId;
		this.creatorId = creatorId;
        this.type = type;
	}

	public Organization() {
		super();
	}

	public List<Organization> getSonOrganizations() {
		return sonOrganizations;
	}

	public void setSonOrganizations(List<Organization> sonOrganizations) {
		this.sonOrganizations = sonOrganizations;
	}

	public List<Announce> getAnnounces() {
		return Announces;
	}

	public void setAnnounces(List<Announce> Announces) {
		this.Announces = Announces;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Organization getParentId() {
		return parentId;
	}

	public void setParentId(Organization parentId) {
		this.parentId = parentId;
	}

	public User getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(User creatorId) {
		this.creatorId = creatorId;
	}

    @Override
    public String toString() {
        return JsonFormatUtil.getJsonFormatString(this);
    }
}