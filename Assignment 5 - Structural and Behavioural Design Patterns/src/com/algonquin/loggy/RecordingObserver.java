package com.algonquin.loggy;

public class RecordingObserver implements Observer {

	private String fileName;
	private String ccFile;
	private Subject recording;
	private Long fileSize;

	public RecordingObserver(Subject recording) {
		this.recording = recording;
		recording.registerObserver(this);
	}

	@Override
	public void update(String ccFile, String fileName, Long fileSize) {
		this.ccFile = ccFile;
		this.fileName = fileName;
		this.fileSize = fileSize;
		display();
	}

	public void display() {

		System.out.println("RecordingObserver Reporting - RecordingName: " + fileName + " has attched ccFile: " + ccFile
				+ " final file size on disk: " + fileSize + "\n");

	}

}
