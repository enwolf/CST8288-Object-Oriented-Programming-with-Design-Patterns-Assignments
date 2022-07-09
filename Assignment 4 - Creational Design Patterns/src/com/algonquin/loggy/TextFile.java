
package com.algonquin.loggy;

public class TextFile extends File {

	public TextFile() {

	}

	public TextFile(String name, String type, String content, Long size) {
		super(name, type, content, size);

	}

	@Override
	public void postProcess() {
		super.postProcess();
		// trigger translation
		System.out.println("This text file is going to be translated");
	}

}
