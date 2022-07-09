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

	public LogBuilder() {

	}

	public LogBuilder setUUID(UUID uuid) {

		this.uuid = uuid;

		return this;

	}

	public LogBuilder setshortCode(String shortCode) {

		this.shortCode = shortCode;

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

	public LogBuilder setDate(Date date) {

		this.date = date;

		return this;

	}

	public LogBuilder setFile(File attachment) {

		this.attachment = attachment;

		return this;

	}

	public Log createLog() {

		return new Log(uuid, shortCode, name, description, date, attachment);
	}

}
