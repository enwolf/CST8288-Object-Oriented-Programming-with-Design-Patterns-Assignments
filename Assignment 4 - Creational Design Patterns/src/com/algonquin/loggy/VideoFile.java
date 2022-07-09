package com.algonquin.loggy;

public class VideoFile extends File {

	public VideoFile(String name, String type, String content, Long size) {

		super(name, type, content, size);

	}

	@Override
	public void postProcess() {

		super.postProcess();

		System.out.println("This video file is going to be closed captioned");

	}

}
