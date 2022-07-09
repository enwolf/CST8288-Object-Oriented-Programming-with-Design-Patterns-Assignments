package com.algonquin.loggy;

public class ImageFile extends File {

	public ImageFile(String name, String type, String content, Long size) {
		super(name, type, content, size);
	}

	@Override
	public void postProcess() {
		super.postProcess();
		System.out.println("This image file is going to be described");
	}

}
