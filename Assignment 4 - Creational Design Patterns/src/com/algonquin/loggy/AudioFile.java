package com.algonquin.loggy;

import java.util.Arrays;
import java.util.List;

public class AudioFile extends File {

	public static final List<String> contentTypes = Arrays.asList("MP3", "WAV", "AAC");

	public AudioFile(String name, String type, String content, Long size) {

		super(name, type, content, size);

	}

	@Override
	public void postProcess() {

		super.postProcess();
		System.out.println("This audio file is going to be transcoded and then closed captioned");

	}

}
