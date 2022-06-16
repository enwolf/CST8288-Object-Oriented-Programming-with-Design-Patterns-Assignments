package com.algonquin.loggy.beans;

import java.time.LocalDateTime;

public class TextLog extends Log {

	public TextLog() {
		super();
		
	}
	
	public TextLog(String title, String content ) {
		super(title, content);
		
	}

	public TextLog(String title, String content, LocalDateTime timeStamp) {
		super(title, content, timeStamp);
		
	}

	
	
	
	
}
