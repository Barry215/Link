package cn.SkyShadow.model;

public class Content {
	private Long contentId;

	private Byte ord;

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", ord=" + ord
				+ ", contentType=" + contentType + ", text=" + text + ", img="
				+ img + ", At=" + at + ", Nominate=" + nominate + ", Voice="
				+ voice + ", Video=" + video + ", Expr=" + expr
				+ ", FileGroup=" + fileGroup + ", File=" + file + ", sender="
				+ sender + "]";
	}

	public Content(Long contentId, Byte ord, String contentType, User sender) {
		super();
		this.contentId = contentId;
		this.ord = ord;
		this.contentType = contentType;
		this.sender = sender;
	}

	public Content() {
		super();
	}

	public Content(Byte ord, String contentType, User sender) {
		super();
		this.ord = ord;
		this.contentType = contentType;
		this.sender = sender;
	}

	private String contentType;

	private String text;

	private Imagine img;

	private At at;

	private Nominate nominate;

	private Voice voice;

	private Video video;

	private Expr expr;

	private FileGroup fileGroup;

	private File file;

	private User sender;

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

	public Imagine getImg() {
		return img;
	}

	public void setImg(Imagine img) {
		this.img = img;
	}

	public At getAt() {
		return at;
	}

	public void setAt(At at) {
		this.at = at;
	}

	public Nominate getNominate() {
		return nominate;
	}

	public void setNominate(Nominate nominate) {
		this.nominate = nominate;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Expr getExpr() {
		return expr;
	}

	public void setExpr(Expr expr) {
		this.expr = expr;
	}

	public FileGroup getFileGroup() {
		return fileGroup;
	}

	public void setFileGroup(FileGroup fileGroup) {
		this.fileGroup = fileGroup;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
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