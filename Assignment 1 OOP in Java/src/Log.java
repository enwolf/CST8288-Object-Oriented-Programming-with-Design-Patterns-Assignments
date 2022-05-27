/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

import java.sql.Timestamp;
import java.sql.Date;

public abstract class Log implements CRUDInterface{

	
	private int ID;
	private String uniqueShortCode;
	private String name;
	private Date date;
	private Timestamp timeStamp;
	private String description;
	private File attachFile;

	//CONSTRUCTOR START
	
	Log(){
		this.ID = 0;
		this.uniqueShortCode = "abc-abc-abc";
		this.name = null;
		this.date = null;
		this.description = null;
		this.attachFile = null;
	}	
	
	public Log(int ID) {		
		this.ID = ID;
	}
	

	public Log(int ID, String uniqueShortCode) {		
		this.ID = ID;
		this.uniqueShortCode = uniqueShortCode;
	}
	
	public Log(int ID, String uniqueShortCode, String name) {
		this.ID = ID;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
	}
	
	public Log(int ID, String uniqueShortCode, String name, Date date) {		
		this.ID = ID;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
	}	
	
	public Log(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp) {		
		this.ID = ID;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.timeStamp = timeStamp;
	}

	public Log(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description) {
		this.ID = ID;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.timeStamp = timeStamp;
		this.description = description;
	}


	public Log(int ID, String uniqueShortCode, String name, Date date, Timestamp timeStamp, String description, File attachFile) {		
		this.ID = ID;
		this.uniqueShortCode = uniqueShortCode;
		this.name = name;
		this.date = date;
		this.description = description;
		this.attachFile = attachFile;
	}
	
	//CONSTRUCTOR END
	
	@Override
	public void create() {
		System.out.println( "Created New Log: \nLog ID: " + this.ID + "\nLog USC: " + this.uniqueShortCode + "\nLog Name: " + this.name + "\nCreate() Compleate.\n"  );
		
	}

	@Override
	public void read() {
		System.out.println( "Reading Log: \nLog ID: " + this.ID + "\nUniqueShortCode: " + this.uniqueShortCode + "\nLog Name: " + this.name + "\nCreated: " + this.date + 
						    "\nLog Timestamp: " + this.timeStamp +  "\nLog description: " + this.description + "\nRead() Compleate.\n"  );	
	}
	
	@Override
	public void update() {
		System.out.println( "Updateing Log: \nLog ID: " + this.ID + "\nLog USC " + this.uniqueShortCode +  "\nLog Name: " + this.name + "\nUpdate() Compelate.\n" );
	}

	@Override
	public void delete() {
		System.out.println( "Deleteing Log: \nLog ID: " + this.ID + "\nLog USC " + this.uniqueShortCode +  "\nLog Name: " + this.name + "\nDeleted() Compelate.\n" );
	}
		
	
	public void generateUSC() {
		System.out.println( "Generating Unique Short Code in formate 'abc-abc-abc' " + " for " + this.name + "\n" );		
	}

	
	public void generateLogID() {
		System.out.println( "Generating ID value for Log: " + this.name  + "\n" );
		
	}
	
	
	public void generateTimeStamp() {		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		System.out.println( "Generating Timestamp: " + timeStamp + " attaching to Log \nLog Name: " + this.name + "\nWith Log ID: " + this.ID +  "\nWith Log USC: " + this.uniqueShortCode + "\n" );		
	}	
	
	
	public void atttachFile(File fileName) {
		
		//super dirty way to avoid having to handle a NullPointerException error.  
		if (fileName == null) {
			System.out.println("Error Detected: Attempting to attach null file to log");
			return;
		}
		
		System.out.println("Attaching file:" + fileName.getFileName() + " to \nLog Name: " + this.name + " succesfully complated.");	
	}

	//ABSTRACT METHODS START
	
	public abstract void validateFileType(File filename);
	public abstract void validateFileSize(File filename);

	//ABSTRACT METHODS END	
		
	//SETTERS START
	public void setID(int ID) {
		this.ID = ID;
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

	//GETTERS END
	
	
} //END OF CLASS

