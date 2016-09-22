package cn.SkyShadow.model;

public class Video {
	private Long videoId;

	private File fileRawId;

	private File fileZipId;

	private Integer length;

	private String fileType;

	public Video() {
		super();
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", fileRawId=" + fileRawId
				+ ", fileZipId=" + fileZipId + ", length=" + length
				+ ", fileType=" + fileType + "]";
	}

	public Video(File fileZipId, Integer length, String fileType) {
		super();
		this.fileZipId = fileZipId;
		this.length = length;
		this.fileType = fileType;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public File getFileRawId() {
		return fileRawId;
	}

	public void setFileRawId(File fileRawId) {
		this.fileRawId = fileRawId;
	}

	public File getFileZipId() {
		return fileZipId;
	}

	public void setFileZipId(File fileZipId) {
		this.fileZipId = fileZipId;
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