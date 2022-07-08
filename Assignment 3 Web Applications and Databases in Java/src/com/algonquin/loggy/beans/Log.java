package com.algonquin.loggy.beans;



import java.util.Date;
import java.util.UUID;

public abstract class Log {
    

	private String ID;
    private String title;
    private String content;
    private Date timestamp;
    
    Log(){
    	this.ID = UUID.randomUUID().toString();
    	
    }
    
	public Log(String title, String content) {
		this.ID = UUID.randomUUID().toString();
		this.title = title;
		this.content = content;
	}
    
	public Log(String title, String content, Date timeStamp) {
		this.ID = UUID.randomUUID().toString();
		this.title = title;
		this.content = content;
		this.timestamp = timeStamp;
	}
	
	public String getId() {
		return ID;
	}
	public void setId(String ID) {
		this.ID = ID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}

}