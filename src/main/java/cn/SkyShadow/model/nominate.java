package cn.SkyShadow.model;

public class nominate {
	private Long nominateId;

	private user initator;

	public nominate() {
		super();
	}

	public nominate(user initator) {
		super();
		this.initator = initator;
	}

	@Override
	public String toString() {
		return "nominate [nominateId=" + nominateId + ", initator=" + initator
				+ "]";
	}

	public Long getNominateId() {
		return nominateId;
	}

	public void setNominateId(Long nominateId) {
		this.nominateId = nominateId;
	}

	public user getInitator() {
		return initator;
	}

	public void setInitator(user initator) {
		this.initator = initator;
	}

}