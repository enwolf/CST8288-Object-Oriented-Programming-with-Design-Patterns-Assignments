/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/
	
import java.sql.Timestamp;
import java.sql.Date;

public class VideoLog extends Log{

	private final String TYPE = "VIDEO";
	private final int MIN_FILE_SIZE = 100;
	private final int MAX_FILE_SIZE = 999;
	private final String VALID_FILE_TYPE[] = {".mp4" , ".mov", ".mpeg" , ".avi", ".gp3" };
	
	//CONSTRUCTOR START	
	public VideoLog() {	}
	
	public VideoLog(int ID){
		super(ID);	
	}
	
	public VideoLog(int ID, String uniqueShortCode ){
		super(ID, uniqueShortCode);	
	}
	
	public VideoLog(int ID, String uniqueShortCode, String name ){
		super(ID, uniqueShortCode, name);						
	}	
	
	public VideoLog(int ID, String uniqueShortCode, String name,  Date date ){
		super(ID, uniqueShortCode, name, date);		
	}	
	
	public VideoLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp ){
		super(ID, uniqueShortCode, name, date, timeStamp);	
	}
	
	public VideoLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp, String description ){
		super(ID, uniqueShortCode, name, date, timeStamp, description);		
	}	
		
	
	public VideoLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, File attachFile){
			super(ID, uniqueShortCode, name, date, timeStamp, description, attachFile);		
	}
	//CONSTRUCTOR END
		
	public void generateClosedCaption(File fileName){
		
		System.out.println("Compleated generation of closed captions for Video Log " + this.getName() );
	}
	
	public void transcodeVideoFile(File fileName){
		System.out.println("Compleated transcoding of video file for Video Log " + this.getName() + "Video File: " + fileName.getFileName() );
	}	
		
	@Override
	public void validateFileType(File fileName) {

		boolean match = false;

		for (int i = 0; i < VALID_FILE_TYPE.length; i++) {
			
			if (VALID_FILE_TYPE[i].equals(fileName.getFileType())) {
				System.out.println("Accepted: compatible vidle file found, Uploading...");
				match = true;
			}			
		}		
		if (match != true) {
			System.out.println("Error: incompatible video file detected. Please select a valid Video File.");
		}		
	}
	
	@Override
	public void validateFileSize(File fileName) {
		
		if (fileName.getFileSize() < MIN_FILE_SIZE) {
			System.out.println("Video file is to small");
		}
		
		if (fileName.getFileSize() > MAX_FILE_SIZE) {
			System.out.println("Video file is to large");
		}
		
		if (fileName.getFileSize() >= MIN_FILE_SIZE && fileName.getFileSize() <= MAX_FILE_SIZE) {
			
			System.out.println("Filesize correct: Attching video file. Uploading....");	
		}		
	}

	public String getTYPE() {
		return TYPE;
	}
	
} //END OF CLASS


