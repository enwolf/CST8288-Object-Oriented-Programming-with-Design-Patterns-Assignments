package com.algonquin.loggy;

import java.util.Date;
import java.util.UUID;

public class LogBuilder {

	private UUID uuid;
	private String shortCode;
	private String name;
	private String description;
	private Date date;
	private File attachment;

	ShortCodeGenerator shortCodeGenerator = ShortCodeGenerator.getInstance();

	public LogBuilder() {

	}

	// Was hopping to use this to generate all logs by creating a log of the type
	// parent and then casting as need but it appears I need to create the
	// Log.java file in a more <generic> way to be able to achieve that and since we
	// were also asked to make Log a concrete class I was never able to change the
	// data type of the log object to anything else no mater how hard I tried.

	public Log createLog() {

		return new Log(uuid, shortCode, name, description, date, attachment);
	}

	public AudioLog createAudioLog() {

		return new AudioLog(uuid, shortCode, name, description, date, attachment);
	}

	public ImageLog createImageLog() {

		return new ImageLog(uuid, shortCode, name, description, date, attachment);
	}

	public TextLog createTextLog() {

		return new TextLog(uuid, shortCode, name, description, date, attachment);
	}

	public VideoLog createVideoLog() {

		return new VideoLog(uuid, shortCode, name, description, date, attachment);
	}

	public LogBuilder setUUID() {

		this.uuid = UUID.randomUUID();

		return this;

	}

	public LogBuilder setShortCode() {

		this.shortCode = shortCodeGenerator.shortCode();

		return this;

	}

	public LogBuilder setName(String name) {

		this.name = name;

		return this;

	}

	public LogBuilder setDescription(String description) {

		this.description = description;

		return this;

	}

	public LogBuilder setDate() {

		this.date = new Date();

		return this;

	}

	public LogBuilder setFile(File attachment) {

		this.attachment = attachment;

		return this;

	}

}
