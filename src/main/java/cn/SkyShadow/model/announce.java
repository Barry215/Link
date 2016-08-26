package cn.SkyShadow.model;

import java.util.Date;
import java.util.List;

public class announce {
	private Long annId;

	private List<content> contentId;

	private Date time;

	private user author;

	@Override
	public String toString() {
		return "announce [annId=" + annId + ", contentId=" + contentId
				+ ", time=" + time + ", author=" + author + "]";
	}

	public Long getAnnId() {
		return annId;
	}

	public void setAnnId(Long annId) {
		this.annId = annId;
	}

	public List<content> getContentId() {
		return contentId;
	}

	public void setContentId(List<content> contentId) {
		this.contentId = contentId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public user getAuthor() {
		return author;
	}

	public void setAuthor(user author) {
		this.author = author;
	}

	public announce() {
		super();
	}

	public announce(List<content> contentId, user author) {
		super();
		this.contentId = contentId;
		this.author = author;
	}

}