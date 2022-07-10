package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ImageLog extends Log {

	public static final List<String> contentTypes = Arrays.asList("PNG", "JPG", "GIF", "SVG");

	public ImageLog() {

	}

	public ImageLog(UUID uuid, String code, String name, String description, Date date, File attachment) {
		super(uuid, code, name, description, date, attachment);
	}

	@Override
	public boolean isValidContentType(String type) {

		return ImageLog.contentTypes.contains(type);
	}

	@Override
	public void attachFile(String name, String type, String content, Long size) throws Exception {

		super.attachFile(name, type, content, size);

		System.out.println("Attaching " + name + " to " + this.getName());

		this.setAttachment(new ImageFile(name, type, content, size));

		ImageFile attachment = (ImageFile) this.getAttachment();

		attachment.postProcess();
	}

}
