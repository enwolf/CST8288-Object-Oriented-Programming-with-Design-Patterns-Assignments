/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-26	

*/

public class VideoFile extends File{
	
	private String videoCaption;

	//CONSTRUCTOR START
	
	public VideoFile() {
		super();
	}
	
	public VideoFile(String fileName){
		super(fileName);
	}
	
	public VideoFile(String fileName, String fileType){
		super(fileName, fileType);
	}
	
	public VideoFile(String fileName, String fileType, int fileSize){
		super(fileName, fileType, fileSize);
	}
	
	public VideoFile(String fileName, String fileType, String videoCaption) {
		super(fileName, fileType );
		this.videoCaption = videoCaption;		
	}		
	//CONSTRUCTOR END

	public VideoFile(String fileName, String fileType, int fileSize, String videoCaption) {
		super(fileName, fileType, fileSize);
		this.videoCaption = videoCaption;
	}
	
	//GETTER SETTERS START
	public String getVideoCaption() {
		return videoCaption;
	}

	public void setVideoCaption(String videoCaption) {
		this.videoCaption = videoCaption;
	}
	//GETTER SETTERS END
	
} //END OF CLASS
