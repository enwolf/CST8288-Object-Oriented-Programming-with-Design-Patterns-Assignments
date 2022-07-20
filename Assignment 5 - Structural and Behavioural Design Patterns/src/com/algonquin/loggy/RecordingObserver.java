package com.algonquin.loggy;

public class RecordingObserver implements Observer {

	private String fileName;
	private String ccFile;
	private Subject recording;

	public RecordingObserver(Subject recording) {
		this.recording = recording;
		recording.registerObserver(this);
	}

	@Override
	public void update(String ccFile, String fileName) {
		this.ccFile = ccFile;
		this.fileName = fileName;
		display();
	}

	public void display() {

		System.out.println(
				"RecordingObserver Reproting - RecordingName: " + fileName + " has attched ccFile: " + ccFile + "\n");

	}

}
