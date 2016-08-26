package cn.SkyShadow.model;

public class file {
	private Long fileId;

	private String filePath;

	private String ascriptionType;

	private user user;

	private occupation occupation;

	private organization organization;

	private String filename;

	private Long filesize;

	private String suffix;

	private String ispublic;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}

	public String getAscriptionType() {
		return ascriptionType;
	}

	public void setAscriptionType(String ascriptionType) {
		this.ascriptionType = ascriptionType == null ? null : ascriptionType
				.trim();
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(occupation occupation) {
		this.occupation = occupation;
	}

	public organization getOrganization() {
		return organization;
	}

	public void setOrganization(organization organization) {
		this.organization = organization;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename == null ? null : filename.trim();
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix == null ? null : suffix.trim();
	}

	public String getIspublic() {
		return ispublic;
	}

	public void setIspublic(String ispublic) {
		this.ispublic = ispublic == null ? null : ispublic.trim();
	}

	@Override
	public String toString() {
		return "file [fileId=" + fileId + ", filePath=" + filePath
				+ ", ascriptionType=" + ascriptionType + ", user=" + user
				+ ", occupation=" + occupation + ", organization="
				+ organization + ", filename=" + filename + ", filesize="
				+ filesize + ", suffix=" + suffix + ", ispublic=" + ispublic
				+ "]";
	}

	public file(String filePath, String ascriptionType,
			String filename, Long filesize, String suffix, String ispublic) {
		super();
		this.filePath = filePath;
		this.ascriptionType = ascriptionType;
		this.filename = filename;
		this.filesize = filesize;
		this.suffix = suffix;
		this.ispublic = ispublic;
	}

	public file() {
		super();
	}

}