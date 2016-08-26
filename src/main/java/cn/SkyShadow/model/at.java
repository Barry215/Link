package cn.SkyShadow.model;

public class at {
	private Long atId;

	private user initator;

	public Long getAtId() {
		return atId;
	}

	public void setAtId(Long atId) {
		this.atId = atId;
	}

	public user getInitator() {
		return initator;
	}

	public void setInitator(user initator) {
		this.initator = initator;
	}

	public at(user initator) {
		super();
		this.initator = initator;
	}

	@Override
	public String toString() {
		return "at [atId=" + atId + ", initator=" + initator + "]";
	}

	public at() {
		super();
	}

}