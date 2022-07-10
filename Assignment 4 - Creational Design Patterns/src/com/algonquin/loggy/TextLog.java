package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TextLog extends Log {

	public static final List<String> contentTypes = Arrays.asList("DOC", "TXT", "PDF");

	public TextLog() {

	}

	public TextLog(UUID uuid, String code, String name, String description, Date date, File attachment) {
		super(uuid, code, name, description, date, attachment);

	}

	@Override
	public boolean isValidContentType(String type) {

		return TextLog.contentTypes.contains(type);
	}

	@Override
	public void attachFile(String name, String type, String content, Long size) throws Exception {

		super.attachFile(name, type, content, size);

		System.out.println("Attaching " + name + " to " + this.getName());

		this.setAttachment(new TextFile(name, type, content, size));

		TextFile attachment = (TextFile) this.getAttachment();

		attachment.postProcess();

	}

}
