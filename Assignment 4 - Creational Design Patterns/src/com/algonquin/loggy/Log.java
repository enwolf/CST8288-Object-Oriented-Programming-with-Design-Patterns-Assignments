package com.algonquin.loggy;

import java.util.Date;
import java.util.UUID;

public abstract class Log implements Attachable {

	private String name;
	private String description;
	private Date date;
	private UUID uuid;
	private String code;
	private File attachment;
	ShortCodeGenerator shortCodeGenerator = ShortCodeGenerator.getInstance();

	// Constructors
	public Log(String name) {

		this(name, "");
	}

	public Log(String name, String description) {

		this(name, description, new Date());
	}

	public Log(String name, String description, Date date) {

		this.name = name;
		this.description = description;
		this.date = date;
		this.uuid = UUID.randomUUID();
		this.code = shortCodeGenerator.shortCode();

	}

	public Log() {

		this.name = null;
		this.description = null;
		this.date = null;
		this.uuid = null;
		this.code = null;

	}

	// constructors end

	public void create() {
		System.out.println("Log record for " + uuid + " has been created");
	}

	public void read() {
		System.out.println("Log " + uuid + " name:" + name + ", description: " + description + " created on " + date);
	}

	public void update(String name, String description) {
		System.out.println("Log record for " + uuid + " has been updated");
		this.name = name;
		this.description = description;
	}

	public void delete() {
		System.out.println("Log record for " + uuid + " has been deleted");
	}

	public String toString() {
		String out = code + ":" + name + ":" + description + ":" + date;
		if (this.attachment != null) {
			out += " with attachment " + this.attachment.getName();
		}
		return out;
	}

	@Override
	public void attachFile(String name, String type, String content, Long size) throws Exception {
		if (!isValidContentType(type)) {
			System.out.println("ContentType " + type + " can not be attached");
			throw new Exception("ContentType " + type + " can not be attached");
		}
	}

	@Override
	public void attachFile(File file) throws Exception {
		String type = file.getType();

		if (!isValidContentType(type)) {
			System.out.println("ContentType " + type + " can not be attached");
			throw new Exception("ContentType " + type + " can not be attached");
		}

		this.setAttachment(file);
		file.postProcess();
	}

	@Override
	public boolean isValidContentType(String type) {
		return false;
	}

	// Get and Set methods start
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	// Get and Set methods end
}
