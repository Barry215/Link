package cn.SkyShadow.model;

import java.util.List;

public class filegroup {
	private Long filegroupId;

	private String name;

	private List<file> files;

	@Override
	public String toString() {
		return "filegroup [filegroupId=" + filegroupId + ", name=" + name
				+ ", files=" + files + "]";
	}

	public List<file> getFiles() {
		return files;
	}

	public void setFiles(List<file> files) {
		this.files = files;
	}

	public Long getFilegroupId() {
		return filegroupId;
	}

	public void setFilegroupId(Long filegroupId) {
		this.filegroupId = filegroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public filegroup() {
		super();
	}

	public filegroup(String name) {
		super();
		this.name = name;
	}

}