/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

import java.sql.Timestamp;
import java.sql.Date;

public class TextLog extends Log {
	
	private final String TYPE = "TEXT";
	private final int MIN_FILE_SIZE = 1;
	private final int MAX_FILE_SIZE = 25;
	private final String VALID_FILE_TYPE[] = {".txt" , ".doc" ,".pdf" };
	private String language;
	
	//CONSTRUCTOR START
	public TextLog() {		
		
	}
	
	public TextLog(int ID){
		super(ID);	
	}	
	
	public TextLog(int ID, String uniqueShortCode ){
		super(ID, uniqueShortCode);	
	}
	
	public TextLog(int ID, String uniqueShortCode, String name ){
		super(ID, uniqueShortCode, name);						
	}	
	
	public TextLog(int ID, String uniqueShortCode, String name,  Date date ){
		super(ID, uniqueShortCode, name, date);		
	}	
	
	public TextLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp ){
		super(ID, uniqueShortCode, name, date, timeStamp);	
	}
	
	public TextLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp, String description ){
		super(ID, uniqueShortCode, name, date, timeStamp, description);		
	}	
		
	public TextLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type) {
		super(ID, uniqueShortCode, name, date, timeStamp, description);
	}
	
	public TextLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type, File attachFile){
		super(ID, uniqueShortCode, name, date, timeStamp, description, attachFile);		
	}
	
	//CONSTRUCTOR START
	
	public void translateText(File fileName, String language) {
		System.out.println("Translated: " + fileName + " into Langauge: " + language );
	}	
		
	@Override
	public void validateFileType(File fileName) {

		boolean match = false;

		for (int i = 0; i < VALID_FILE_TYPE.length; i++) {
			
			if (VALID_FILE_TYPE[i].equals(fileName.getFileType())) {
				System.out.println("Accepted: compatible text file found, Uploading...");
				match = true;
			}			
		}		
		if (match != true) {
			System.out.println("Error: incompatible text file detected. Please select a valid text File");
		}		
	}
	 
	@Override
	public void validateFileSize(File fileName) {
		
		if (fileName.getFileSize() < MIN_FILE_SIZE) {
			System.out.println("Text file is to small");
		}
		
		if (fileName.getFileSize() > MAX_FILE_SIZE) {
			System.out.println("Text file is to large");
		}
		
		if (fileName.getFileSize() >= MIN_FILE_SIZE && fileName.getFileSize() <= MAX_FILE_SIZE) {
			
			System.out.println("Filesize correct: Attching Text file. Uploading....");	
		}		
	}

	public String getTYPE() {
		return TYPE;
	}
	
} //END OF CLASS
