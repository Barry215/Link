package cn.SkyShadow.model;

public class content {
	private Long contentId;

	private Byte ord;

	@Override
	public String toString() {
		return "content [contentId=" + contentId + ", ord=" + ord
				+ ", contentType=" + contentType + ", text=" + text + ", img="
				+ img + ", at=" + at + ", nominate=" + nominate + ", voice="
				+ voice + ", video=" + video + ", expr=" + expr
				+ ", filegroup=" + filegroup + ", file=" + file + ", sender="
				+ sender + "]";
	}

	public content(Long contentId, Byte ord, String contentType, user sender) {
		super();
		this.contentId = contentId;
		this.ord = ord;
		this.contentType = contentType;
		this.sender = sender;
	}

	public content() {
		super();
	}

	public content(Byte ord, String contentType, user sender) {
		super();
		this.ord = ord;
		this.contentType = contentType;
		this.sender = sender;
	}

	private String contentType;

	private String text;

	private imagine img;

	private at at;

	private nominate nominate;

	private voice voice;

	private video video;

	private expr expr;

	private filegroup filegroup;

	private file file;

	private user sender;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType == null ? null : contentType.trim();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}

	public imagine getImg() {
		return img;
	}

	public void setImg(imagine img) {
		this.img = img;
	}

	public at getAt() {
		return at;
	}

	public void setAt(at at) {
		this.at = at;
	}

	public nominate getNominate() {
		return nominate;
	}

	public void setNominate(nominate nominate) {
		this.nominate = nominate;
	}

	public voice getVoice() {
		return voice;
	}

	public void setVoice(voice voice) {
		this.voice = voice;
	}

	public video getVideo() {
		return video;
	}

	public void setVideo(video video) {
		this.video = video;
	}

	public expr getExpr() {
		return expr;
	}

	public void setExpr(expr expr) {
		this.expr = expr;
	}

	public filegroup getFilegroup() {
		return filegroup;
	}

	public void setFilegroup(filegroup filegroup) {
		this.filegroup = filegroup;
	}

	public file getFile() {
		return file;
	}

	public void setFile(file file) {
		this.file = file;
	}

	public user getSender() {
		return sender;
	}

	public void setSender(user sender) {
		this.sender = sender;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public Byte getOrd() {
		return ord;
	}

	public void setOrd(Byte ord) {
		this.ord = ord;
	}

}