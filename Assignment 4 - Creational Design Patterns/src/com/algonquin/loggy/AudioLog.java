package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AudioLog extends Log {

	public static final List<String> contentTypes = Arrays.asList("MP3", "WAV", "AAC");

	public AudioLog() {
	}

	public AudioLog(UUID uuid, String code, String name, String description, Date date, File attachment) {
		super(uuid, code, name, description, date, attachment);
	}

	@Override
	public boolean isValidContentType(String type) {

		return AudioLog.contentTypes.contains(type);
	}

	@Override
	public void attachFile(String name, String type, String content, Long size) throws Exception {

		super.attachFile(name, type, content, size);

		System.out.println("Attaching " + name + " to " + this.getName());

		this.setAttachment(new AudioFile(name, type, content, size));

		AudioFile attachment = (AudioFile) this.getAttachment();

		attachment.postProcess();
	}

}
