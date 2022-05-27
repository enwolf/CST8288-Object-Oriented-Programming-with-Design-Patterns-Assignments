/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-26	

*/

public class AudioFile extends File {
	
	private String audioCaption;
	
	//CONSTRUCTOR START	
	public AudioFile() {
		super();
	}
	
	public AudioFile(String fileName){
		super(fileName);
	}
	
	public AudioFile(String fileName, String fileType){
		super(fileName, fileType);
	}
	
	public AudioFile(String fileName, String fileType, int fileSize){
		super(fileName, fileType, fileSize);
	}
	
	public AudioFile(String fileName, String fileType, String audioCaption) {
		super(fileName, fileType);
		this.audioCaption = audioCaption;
	}	

	public AudioFile(String fileName, String fileType, int fileSize, String audioCaption) {
		super(fileName, fileType, fileSize);
		this.audioCaption = audioCaption;
	}
	
	//CONSTRUCTOR END
	
	//GETTER SETTERS START
	public String getAudioCaption() {
		return audioCaption;
	}

	public void setAudioCaption(String audioCaption) {
		this.audioCaption = audioCaption;
	}
	//GETTER SETTERS END
	
} //END OF CLASS
