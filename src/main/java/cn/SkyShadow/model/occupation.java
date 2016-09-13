package cn.SkyShadow.model;

public class occupation {
	private Long occupationId;

	private String name;

	private organization organization;

	private mailbox mailbox;

	private Occupation_Power occupation_power;

	public Occupation_Power getOccupation_power() {
		return occupation_power;
	}

	public void setOccupation_power(Occupation_Power occupation_power) {
		this.occupation_power = occupation_power;
	}

	public occupation(String name, cn.SkyShadow.model.organization organization) {
		super();
		this.name = name;
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "occupation [occupationId=" + occupationId + ", name=" + name
				+ ", organization=" + organization + ", mailbox=" + mailbox
				+ "]";
	}
	

	public mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(mailbox mailbox) {
		this.mailbox = mailbox;
	}

	public void setOrganization(organization organization) {
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

	public organization getOrganization() {
		return organization;
	}

	public occupation() {
		super();
	}

}