package com.algonquin.loggy.beans;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public abstract class Log {
    

	private UUID id;
    private String title;
    private String content;
    private LocalDateTime timeStamp;
    
    Log(){
    	this.id = UUID.randomUUID();
    	
    }
    
	public Log(String title, String content) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.content = content;
	}
    
	public Log(String title, String content, LocalDateTime timeStamp) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.content = content;
		this.timeStamp = timeStamp;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}