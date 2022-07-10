package com.algonquin.loggy;

import java.util.Date;
import java.util.UUID;

public class Log implements Attachable {

	private UUID uuid;
	private String code;
	private String name;
	private String description;
	private Date date;
	private File attachment;
	ShortCodeGenerator shortCodeGenerator = ShortCodeGenerator.getInstance();

	// Constructors

	public Log() {

		this.uuid = null;
		this.name = null;
		this.description = null;
		this.date = null;
		this.code = null;
		this.attachment = null;

	}

	public Log(UUID uuid, String code, String name, String description, Date date, File attachment) {

		this.uuid = uuid;
		this.code = code;
		this.name = name;
		this.date = date;
		this.attachment = attachment;
		this.description = description;

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

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	// Get and Set methods end
}
