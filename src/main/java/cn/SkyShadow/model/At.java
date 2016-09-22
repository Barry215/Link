package cn.SkyShadow.model;

public class At {
	private Long atId;

	private User initActor;

	public Long getAtId() {
		return atId;
	}

	public void setAtId(Long atId) {
		this.atId = atId;
	}

	public User getInitActor() {
		return initActor;
	}

	public void setInitActor(User initActor) {
		this.initActor = initActor;
	}

	public At(User initActor) {
		super();
		this.initActor = initActor;
	}

	@Override
	public String toString() {
		return "At [atId=" + atId + ", initActor=" + initActor + "]";
	}

	public At() {
		super();
	}

}