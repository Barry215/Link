package cn.SkyShadow.model;

public class video {
	private Long videoId;

	private file fileRewid;

	private file fileZipid;

	private Integer length;

	private String fileType;

	public video() {
		super();
	}

	@Override
	public String toString() {
		return "video [videoId=" + videoId + ", fileRewid=" + fileRewid
				+ ", fileZipid=" + fileZipid + ", length=" + length
				+ ", fileType=" + fileType + "]";
	}

	public video(file fileZipid, Integer length, String fileType) {
		super();
		this.fileZipid = fileZipid;
		this.length = length;
		this.fileType = fileType;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public file getFileRewid() {
		return fileRewid;
	}

	public void setFileRewid(file fileRewid) {
		this.fileRewid = fileRewid;
	}

	public file getFileZipid() {
		return fileZipid;
	}

	public void setFileZipid(file fileZipid) {
		this.fileZipid = fileZipid;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType == null ? null : fileType.trim();
	}
}