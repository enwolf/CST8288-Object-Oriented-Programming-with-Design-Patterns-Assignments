package com.algonquin.loggy;

import java.util.ArrayList;
import java.util.UUID;

public class Recording implements Subject {

	private UUID uuid;
	private Long fileSize;
	private String fileName;
	private String ccFileMock;
	private String mediaFileMock;
	// reocrding.java is the subject of observer
	private ArrayList<Observer> observers;

	public Recording(UUID uuid, String fileName, Long fileSize) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.mediaFileMock = fileName;
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(ccFileMock, fileName);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		notifyObservers();
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
		notifyObservers();
	}

}
