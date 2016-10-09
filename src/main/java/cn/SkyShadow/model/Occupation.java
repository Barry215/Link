package cn.SkyShadow.model;

import cn.SkyShadow.basic_component.JsonFormatUtil;

public class Occupation {
	private Long occupationId;

	private String name;

	private String rank;

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	private Organization organization;

	private Mailbox mailbox;

	private OccupationPower occupation_power;

	public OccupationPower getOccupation_power() {
		return occupation_power;
	}

	public void setOccupation_power(OccupationPower occupation_power) {
		this.occupation_power = occupation_power;
	}

	public Occupation(String name, Organization organization) {
		super();
		this.name = name;
		this.organization = organization;
	}

	@Override
	public String toString() {
		return JsonFormatUtil.getJsonFormatString(this);
	}
	

	public Mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(Mailbox mailbox) {
		this.mailbox = mailbox;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Long getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Organization getOrganization() {
		return organization;
	}

	public Occupation() {
		super();
	}

}