import java.util.UUID;

/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 2: Concurrency In Java
	Date: 2022-05-29 	
	Objective: To demonstrate principles Concurrency via multi-threading.
*/

public class Recording {
	
	private UUID ID;
	private String fileName;
	private String fileType;
	private Long fileSize;
	private String CCEncoding;
	private String closedCatption;
	
	public Recording() {		
		this.ID = UUID.randomUUID();
	}
	
	public Recording(UUID ID, String fileName, String fileType, Long fileSize, String CCEncoding){		
		this.ID = ID;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.CCEncoding = CCEncoding;		
	}
	
	//SETTERS START
	public void setID(UUID iD) {
		ID = iD;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}	
	public void setEncoding(String CCencoding) {
		this.CCEncoding = CCencoding;
	}	
	public void setClosedCatption(String closedCatption) {
		this.closedCatption = closedCatption;
	}
	
	//SETTERS END
	

	//GETTERS START	
	public UUID getID() {
		return ID;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public String getClosedCatption() {
		return closedCatption;
	}
	public String getEncoding() {
		return CCEncoding;
	}
	
	//GETTERS END

}//END OF CLASS
