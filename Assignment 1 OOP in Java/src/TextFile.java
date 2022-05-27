/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

public final class TextFile extends File {
	
	private String language;

	//CONSTRUCTOR START	
	public TextFile(){
		super();
	}
	
	public TextFile(String fileName){
		super(fileName);
	}
	
	public TextFile(String fileName, int fileSize){
		super(fileName, fileSize);
	}
	
	public TextFile(String fileName, String fileType){
		super(fileName, fileType);
	}
	
	public TextFile(String fileName, String fileType, int fileSize){
		super(fileName, fileType, fileSize);
	}
	
	public TextFile(String fileName, String fileType, String language) {
		super(fileName, fileType );
		this.language = language;		
	}		
	
	public TextFile(String fileName, String fileType, int fileSize, String language) {
		super(fileName, fileType, fileSize);
		this.language = language;		
	}
	
	//CONSTRUCTOR END
		
	//GETTER SETTERS START
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	//GETTER SETTERS END

} //END OF CLASS
