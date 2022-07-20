package com.algonquin.loggy;

import java.util.UUID;

public class Recording implements Subject {
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

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

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
