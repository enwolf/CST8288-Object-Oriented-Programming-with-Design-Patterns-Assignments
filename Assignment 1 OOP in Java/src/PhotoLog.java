/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

import java.sql.Timestamp;
import java.sql.Date;

public class PhotoLog extends Log {

	private final int MIN_FILE_SIZE = 10;
	private final int MAX_FILE_SIZE = 50;
	private final String VALID_FILE_TYPE[] = {".png" , ".jpg" , ".jpeg", ".gif" };
	private String photoAnnotation;

	//CONSTRUCTOR START
	public PhotoLog() {		
		
	}
	
	public PhotoLog(int ID){
		super(ID);	
	}	
	
	public PhotoLog(int ID, String uniqueShortCode ){
		super(ID, uniqueShortCode);	
	}
	
	public PhotoLog(int ID, String uniqueShortCode, String name ){
		super(ID, uniqueShortCode, name);						
	}	
	
	public PhotoLog(int ID, String uniqueShortCode, String name,  Date date ){
		super(ID, uniqueShortCode, name, date);		
	}	
	
	public PhotoLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp ){
		super(ID, uniqueShortCode, name, date, timeStamp);	
	}
	
	public PhotoLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp, String description ){
		super(ID, uniqueShortCode, name, date, timeStamp, description);		
	}	
		
	public PhotoLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type) {
		super(ID, uniqueShortCode, name, date, timeStamp, description, type);

	}			
	public PhotoLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type, File attachFile){
		super(ID, uniqueShortCode, name, date, timeStamp, description, type, attachFile);		
	}
	
	//CONSTRUCTOR END
	
	
	public void attachPhotoAnnotation(File fileName, String photoAnnotation) {
		System.out.println("Atttaching text to image file:  " + fileName.getFileName() );
	}
	
	@Override
	public void validateFileType(File fileName) {
		

		for (int i = 0; i < VALID_FILE_TYPE.length; i++) {
			
			if ( VALID_FILE_TYPE[i].equals(fileName.getFileType()) ) {
				System.out.println("Valid filetype for log type: " + this.getType() );
			}else{
				System.out.println("Invalid filetype for log type: " + this.getType() );
			}			
		}
	}
	
	@Override
	public void validateFileSize(File fileName) {
		
		if (fileName.getFileSize() < MIN_FILE_SIZE) {
			System.out.println("Photo file is to small");
		}
		
		if (fileName.getFileSize() > MAX_FILE_SIZE) {
			System.out.println("Photo file is to large");
		}
		
		if (fileName.getFileSize() >= MIN_FILE_SIZE && fileName.getFileSize() <= MAX_FILE_SIZE) {			
			System.out.println("Photo file is valid to Attach.");	
		}		
		
	}
	
} //END OF CLASS
	
	
	

