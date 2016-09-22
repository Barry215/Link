package cn.SkyShadow.model;

public class Nominate {
	private Long nominateId;

	private User initActor;

	public Nominate() {
		super();
	}

	public Nominate(User initActor) {
		super();
		this.initActor = initActor;
	}

	@Override
	public String toString() {
		return "Nominate [nominateId=" + nominateId + ", initActor=" + initActor
				+ "]";
	}

	public Long getNominateId() {
		return nominateId;
	}

	public void setNominateId(Long nominateId) {
		this.nominateId = nominateId;
	}

	public User getInitActor() {
		return initActor;
	}

	public void setInitActor(User initActor) {
		this.initActor = initActor;
	}

}