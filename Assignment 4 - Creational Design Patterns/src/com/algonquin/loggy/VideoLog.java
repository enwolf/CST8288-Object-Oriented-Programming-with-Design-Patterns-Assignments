package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VideoLog extends Log {

	public static final List<String> contentTypes = Arrays.asList("MP4", "MPG", "MPEG", "M4V");

	public VideoLog() {

	}

	public VideoLog(UUID uuid, String code, String name, String description, Date date, File attachment) {
		super(uuid, code, name, description, date, attachment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidContentType(String type) {

		return VideoLog.contentTypes.contains(type);
	}

	@Override
	public void attachFile(String name, String type, String content, Long size) throws Exception {

		super.attachFile(name, type, content, size);

		System.out.println("Attaching " + name + " to " + this.getName());

		this.setAttachment(new VideoFile(name, type, content, size));

		VideoFile attachment = (VideoFile) this.getAttachment();

		attachment.postProcess();
	}

}
