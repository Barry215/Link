package cn.SkyShadow.model;

public class Imagine {
	private Long imgId;

	private File fileId;

	private Short width;

	private Short length;

	private Imagine rewImg;

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public File getFileId() {
		return fileId;
	}

	public void setFileId(File fileId) {
		this.fileId = fileId;
	}

	public Short getWidth() {
		return width;
	}

	public void setWidth(Short width) {
		this.width = width;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public Imagine getRewImg() {
		return rewImg;
	}

	public void setRewImg(Imagine rewImg) {
		this.rewImg = rewImg;
	}

	public Imagine(File fileId, Short width, Short length, Imagine rewImg) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.length = length;
		this.rewImg = rewImg;
	}

	public Imagine() {
		super();
	}

	public Imagine(File fileId, Short width, Short length) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Imagine [imgId=" + imgId + ", fileId=" + fileId + ", width="
				+ width + ", length=" + length + ", rewImg=" + rewImg + "]";
	}

}