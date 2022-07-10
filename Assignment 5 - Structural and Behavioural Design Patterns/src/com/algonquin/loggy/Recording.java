/**
 * 
 */
package com.algonquin.loggy;

import java.util.UUID;

/**
 * @author jesus
 *
 */
public class Recording {
	private UUID uuid;
	private String fileName;
	private Long fileSize;
	private String mediaFileMock;
	private String ccFileMock;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getMediaFileMock() {
		return mediaFileMock;
	}

	public void setMediaFileMock(String mediaFileMock) {
		this.mediaFileMock = mediaFileMock;
	}

	public String getCcFileMock() {
		return ccFileMock;
	}

	public void setCcFileMock(String ccFileMock) {
		this.ccFileMock = ccFileMock;
	}

	/**
	 * @param uuid
	 * @param fileName
	 * @param fileSize
	 */
	public Recording(UUID uuid, String fileName, Long fileSize) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.mediaFileMock = fileName;
	}

}
