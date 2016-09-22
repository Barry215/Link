package cn.SkyShadow.model;

public class File {
	private Long fileId;

	private String filePath;

	private String ascriptionType;

	private User user;

	private Occupation occupation;

	private Organization organization;

	private String filename;

	private Long fileSize;

	private String suffix;

	private String isPublic;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename == null ? null : filename.trim();
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix == null ? null : suffix.trim();
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic == null ? null : isPublic.trim();
	}

	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", filePath=" + filePath
				+ ", ascriptionType=" + ascriptionType + ", User=" + user
				+ ", Occupation=" + occupation + ", Organization="
				+ organization + ", filename=" + filename + ", fileSize="
				+ fileSize + ", suffix=" + suffix + ", isPublic=" + isPublic
				+ "]";
	}

	public File(String filePath, String ascriptionType,
				String filename, Long fileSize, String suffix, String isPublic) {
		super();
		this.filePath = filePath;
		this.ascriptionType = ascriptionType;
		this.filename = filename;
		this.fileSize = fileSize;
		this.suffix = suffix;
		this.isPublic = isPublic;
	}

	public File() {
		super();
	}

}