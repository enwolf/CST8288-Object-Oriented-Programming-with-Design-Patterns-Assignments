/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

public class PhotoFile extends File{

	private String photoAnnotation;

	//CONSTRUCTOR START	
	public PhotoFile(){
		super();
	}
	
	public PhotoFile(String fileName){
		super(fileName);
	}	
	public PhotoFile(String fileName, int fileSize){
		super(fileName, fileSize);
	}
	
	public PhotoFile(String fileName, String fileType){
		super(fileName, fileType);
	}
	
	public PhotoFile(String fileName, String fileType, int fileSize){
		super(fileName, fileType, fileSize);
	}

	public PhotoFile(String fileName, String fileType, int fileSize, String photoAnnotation) {
		super(fileName, fileType, fileSize);
		this.photoAnnotation = photoAnnotation;
	}	
	//CONSTRUCTOR END
	
	//GETTER SETTERS START
	public String getPhotoAnnotation() {
		return photoAnnotation;
	}

	public void setPhotoAnnotation(String photoAnnotation) {
		this.photoAnnotation = photoAnnotation;
	}
	//GETTER SETTERS END
	
} //END OF CLASS
