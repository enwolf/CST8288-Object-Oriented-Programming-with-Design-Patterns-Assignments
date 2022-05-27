/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	

*/

import java.sql.Timestamp;
import java.sql.Date;

public abstract class Log implements LogInterface{

	private int ID;
	private String uniqueShortCode;
	private String name;
	private Date date;
	private Timestamp timeStamp;
	private String description;
	private String type;
	private File attachFile;
	
	//CONSTRUCTOR START
	
	Log(){
		
	}	
	
	public Log(int iD) {		
		this.ID = iD;
	}
	
	public Log(int iD, String uniqueShortCode) {		
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
	}
	
	public Log(int iD, String uniqueShortCode, String name) {
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
	}
	
	public Log(int iD, String uniqueShortCode, String name, Date date) {		
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
	}	
	
	public Log(int iD, String uniqueShortCode, String name, Date date, Timestamp timeStamp) {		
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.timeStamp = timeStamp;
	}

	public Log(int iD, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description) {
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.timeStamp = timeStamp;
		this.description = description;
	}

	public Log(int iD, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description,	String type) {		
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.timeStamp = timeStamp;
		this.description = description;
		this.type = type;
	}	

	public Log(int iD, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, String type, File attachFile) {		
		this.ID = iD;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.description = description;
		this.type = type;
		this.attachFile = attachFile;
	}
	
	//CONSTRUCTOR END
	
	@Override
	public void create() {
		System.out.println( "Log ID: " + this.ID + "Log USC " + this.uniqueShortCode + " Log Name " + this.name + " has been created " );
		
	}

	@Override
	public void read() {
		System.out.println( "Reading Log info for: Log ID: " + this.ID + " UniqueShortCode: " + this.uniqueShortCode + " Log Name: " + this.name + " Creatd Date: " + this.date + 
						    "Log Timestamp: " + this.timeStamp +  "Log description: " + this.description );	
	}
	
	@Override
	public void update() {
		System.out.println( "Log ID: " + this.ID + " Log USC " + this.uniqueShortCode +  " Log Name " + name + " has been updated." );
	}

	@Override
	public void delete() {
		System.out.println( "Log ID: " + this.ID + " Log USC " + this.uniqueShortCode +  " Log Name " + name + " has been deleted." );
	}
		
	@Override
	public void generateUSC() {
		System.out.println( " Generating Unique Short Code in formate 'abc-abc-abc' " + " for " + this.name );		
	}

	@Override
	public void generateLogID() {
		System.out.println( " Generating ID value for Log: " + this.name);
		
	}
	
	@Override
	public void generateTimeStamp() {		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		System.out.println( " Generating Timestamp: " + timeStamp + " attaching to Log Name: " + this.name + " Log ID: " + this.ID +  " Log USC: " + this.uniqueShortCode  );		
	}	
	
	public void atttachFile(File fileName) {
		System.out.println(" Attaching " + fileName + " to Log:" + this.name + " succesfully complated ");	
	}

	//ABSTRACT METHODS START	
	public abstract void validateFileType(File filename);
	public abstract void validateFileSize(File filename);

	//ABSTRACT METHODS END	
	
	
	//SETTERS START
	public void setID(int iD) {
		this.ID = iD;
	}
	
	public void setUniqueShortCode(String uniqueShortCode) {
		this.uniqueShortCode = uniqueShortCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setAttachedFile(File attachFile) {
		this.attachFile = attachFile;
	}
		
	//SETTERS END
	
	
	
	//GETTERS START 	
	public int getID() {
		return ID;
	}

	public String getUniqueShortCode() {
		return uniqueShortCode;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public String getDescription() {
		return description;
	}

	public File getAttachedFile() {
		return attachFile;
	}

	public String getType() {
		return type;
	}

	//GETTERS END
	
	
} //END OF CLASS

