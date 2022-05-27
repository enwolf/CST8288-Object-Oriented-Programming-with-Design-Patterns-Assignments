/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

 public abstract class File implements CRUDInterface{

	private String fileName;
	private String fileType;
	private int fileSize;

		
	public File() {
		this.fileName = null;
		this.fileType = null;
		this.fileSize = 0;		
		
	}

	public File(String fileName) {
		this.fileName = fileName;
	}

	public File(String fileName, String fileType) {
		this.fileName = fileName;
		this.fileType = fileType;
	}
	
	public File(String fileName, int fileSize) {
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public File(String fileName, String fileType, int fileSize) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	@Override
	public void create() {
		System.out.println( "Creating File: " + this.fileName + " has been created.");
	}

	@Override
	public void update() {
		System.out.println( "Updateing File: " + this.fileName + " has been updated.");		
	}
	
	@Override
	public void read() {
		System.out.println( "Reading File: " + this.fileName + ", FileType: " + this.fileType + ", FileSize: " + this.fileSize );				
	}
	
	@Override
	public void delete() {
		System.out.println( "Deleteing File: " + this.fileName + " has been deleted.");		
	}
	
	public void copy() {
		System.out.println( "Copying File: " + this.fileName + " has been copyed.");		
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}	
		
	public String getFileName() {
		return fileName;
	}

	public String getFileType() {
		return fileType;
	}
	
	public int getFileSize() {
		return fileSize;
	}
	

} //END OF CLASS
