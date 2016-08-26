package cn.SkyShadow.model;

public class voice {
	private Long voiceId;

	private file fileId;

	private Byte length;

	@Override
	public String toString() {
		return "voice [voiceId=" + voiceId + ", fileId=" + fileId + ", length="
				+ length + "]";
	}

	public voice() {
		super();
	}

	public voice(file fileId, Byte length) {
		super();
		this.fileId = fileId;
		this.length = length;
	}

	public Long getVoiceId() {
		return voiceId;
	}

	public void setVoiceId(Long voiceId) {
		this.voiceId = voiceId;
	}

	public file getFileId() {
		return fileId;
	}

	public void setFileId(file fileId) {
		this.fileId = fileId;
	}

	public Byte getLength() {
		return length;
	}

	public void setLength(Byte length) {
		this.length = length;
	}
}