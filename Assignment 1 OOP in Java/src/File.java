/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

 public abstract class File implements FileInterface{

	private String fileName;
	private String fileType;
	private int fileSize;

		
	public File() {
	
		
		
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
		System.out.println( "File: " + this.fileName + "has been created.");
	}

	@Override
	public void update() {
		System.out.println( "File: " + this.fileName + "has been updated.");
		
	}
	@Override
	public void read() {
		System.out.println( "Reading: " + this.fileName + " Has FileType: " + this.fileType + " Has FileSize: " + this.fileSize );
				
	}
	@Override
	public void delete() {
		System.out.println( "File: " + this.fileName + "has been deleted.");		
	}
	@Override
	public void copy() {
		System.out.println( "File: " + this.fileName + "has been copyed.");
		
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
