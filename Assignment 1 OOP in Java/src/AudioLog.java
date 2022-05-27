/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-26	

*/

import java.sql.Timestamp;
import java.sql.Date;

public class AudioLog extends Log{

	private final int MIN_FILE_SIZE = 50;
	private final int MAX_FILE_SIZE = 200;
	private final String VALID_FILE_TYPE[] = {".mp3" , ".ogg" ,".gp3" };
	
	//CONSTRUCTOR START
	public AudioLog() {		
		
	}
	
	public AudioLog(int ID, String uniqueShortCode ){
		super(ID, uniqueShortCode);	
	}
	
	public AudioLog(int ID, String uniqueShortCode, String name ){
		super(ID, uniqueShortCode, name);						
	}	
	
	public AudioLog(int ID, String uniqueShortCode, String name,  Date date ){
		super(ID, uniqueShortCode, name, date);		
	}	
	
	public AudioLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp ){
		super(ID, uniqueShortCode, name, date, timeStamp);	
	}
	
	public AudioLog(int ID, String uniqueShortCode, String name,  Date date, Timestamp timeStamp, String description ){
		super(ID, uniqueShortCode, name, date, timeStamp, description);		
	}	
		
	public AudioLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type) {
		super(ID, uniqueShortCode, name, date, timeStamp, description, type);

	}			
	public AudioLog(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type, File attachFile){
			super(ID, uniqueShortCode, name, date, timeStamp, description, type, attachFile);		
	}		
	//CONSTRUCTOR END
	
	public void generateClosedCaption(File fileName){
		
		System.out.print("Compleated generation of closed captions for Audio Log " + this.getName() );
	}
	
	public void transcodeAudio(File fileName){
		System.out.print("Compleated transcoding of closed captions for Audio Log " + this.getName() );
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
			System.out.println("Audio file is to small");
		}
		
		if (fileName.getFileSize() > MAX_FILE_SIZE) {
			System.out.println("Audio file is to large");
		}
		
		if (fileName.getFileSize() >= MIN_FILE_SIZE && fileName.getFileSize() <= MAX_FILE_SIZE) {
			
			System.out.println("Audio file is valid to Attach.");	
		}		
	}

	public int getMIN_FILE_SIZE() {
		return MIN_FILE_SIZE;
	}

	public int getMAX_FILE_SIZE() {
		return MAX_FILE_SIZE;
	}

	public String[] getVALID_FILE_TYPE() {
		return VALID_FILE_TYPE;
	}
	
} //END OF CLASS
