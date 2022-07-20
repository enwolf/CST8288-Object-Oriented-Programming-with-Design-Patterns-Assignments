package com.algonquin.loggy;

import java.util.UUID;

public class Recording {
	private UUID uuid;
	private String fileName;
	private Long fileSize;
	private String mediaFileMock;
	private String ccFileMock;

	public Recording(UUID uuid, String fileName, Long fileSize) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.mediaFileMock = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getMediaFileMock() {
		return mediaFileMock;
	}

	public void setMediaFileMock(String mediaFileMock) {
		this.mediaFileMock = mediaFileMock;
	}

	public String getCcFileMock() {
		return ccFileMock;
	}

	public void setCcFileMock(String ccFileMock) {
		this.ccFileMock = ccFileMock;
	}

}
