package cn.SkyShadow.model;

public class imagine {
	private Long imgId;

	private file fileId;

	private Short width;

	private Short length;

	private imagine rewImg;

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public file getFileId() {
		return fileId;
	}

	public void setFileId(file fileId) {
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

	public imagine getRewImg() {
		return rewImg;
	}

	public void setRewImg(imagine rewImg) {
		this.rewImg = rewImg;
	}

	public imagine(file fileId, Short width, Short length, imagine rewImg) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.length = length;
		this.rewImg = rewImg;
	}

	public imagine() {
		super();
	}

	public imagine(file fileId, Short width, Short length) {
		super();
		this.fileId = fileId;
		this.width = width;
		this.length = length;
	}

	@Override
	public String toString() {
		return "imagine [imgId=" + imgId + ", fileId=" + fileId + ", width="
				+ width + ", length=" + length + ", rewImg=" + rewImg + "]";
	}

}