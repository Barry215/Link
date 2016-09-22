package cn.SkyShadow.model;

import java.util.List;

public class FileGroup {
	private Long fileGroupId;

	private String name;

	private List<File> files;

	@Override
	public String toString() {
		return "FileGroup [fileGroupId=" + fileGroupId + ", name=" + name
				+ ", files=" + files + "]";
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public Long getFileGroupId() {
		return fileGroupId;
	}

	public void setFileGroupId(Long fileGroupId) {
		this.fileGroupId = fileGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public FileGroup() {
		super();
	}

	public FileGroup(String name) {
		super();
		this.name = name;
	}

}