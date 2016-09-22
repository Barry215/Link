package cn.SkyShadow.model;

public class Voice {
	private Long voiceId;

	private File fileId;

	private Byte length;

	@Override
	public String toString() {
		return "Voice [voiceId=" + voiceId + ", fileId=" + fileId + ", length="
				+ length + "]";
	}

	public Voice() {
		super();
	}

	public Voice(File fileId, Byte length) {
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

	public File getFileId() {
		return fileId;
	}

	public void setFileId(File fileId) {
		this.fileId = fileId;
	}

	public Byte getLength() {
		return length;
	}

	public void setLength(Byte length) {
		this.length = length;
	}
}