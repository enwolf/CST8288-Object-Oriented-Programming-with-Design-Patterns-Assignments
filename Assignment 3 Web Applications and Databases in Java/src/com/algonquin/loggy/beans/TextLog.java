package com.algonquin.loggy.beans;


import java.util.Date;

public class TextLog extends Log {

	public TextLog() {
		super();
		
	}
	
	public TextLog(String title, String content ) {
		super(title, content);
		
	}

	public TextLog(String title, String content, Date timeStamp) {
		super(title, content, timeStamp);
		
	}	
	
	
	
	
}
