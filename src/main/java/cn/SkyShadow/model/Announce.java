package cn.SkyShadow.model;

import java.util.Date;
import java.util.List;

public class Announce {
	private Long annId;

	private List<Content> contentId;

	private Date time;

	private User author;

	@Override
	public String toString() {
		return "Announce [annId=" + annId + ", contentId=" + contentId
				+ ", time=" + time + ", author=" + author + "]";
	}

	public Long getAnnId() {
		return annId;
	}

	public void setAnnId(Long annId) {
		this.annId = annId;
	}

	public List<Content> getContentId() {
		return contentId;
	}

	public void setContentId(List<Content> contentId) {
		this.contentId = contentId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Announce() {
		super();
	}

	public Announce(List<Content> contentId, User author) {
		super();
		this.contentId = contentId;
		this.author = author;
	}

}