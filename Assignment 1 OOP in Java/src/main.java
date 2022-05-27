/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

import java.sql.Date;
import java.sql.Timestamp;


public class main {

	public static void main(String[] args) {
			
		//Used for testing specific methods and parameters. 
		Date today = new Date(0);
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		
		//Video Log test objects
		VideoLog vidLog1 = new VideoLog();
		VideoLog vidLog2 = new VideoLog(02);
		VideoLog vidLog3 = new VideoLog(03,"abc-abc-abc", "Fancy Title!", today, timeStamp, "I'm A video log!!" );

		//Audio Log test objects
		AudioLog audioLog1 = new AudioLog();
		AudioLog audioLog2 = new AudioLog(02);
		AudioLog audioLog3 = new AudioLog(03,"abc-abc-abc", "Sweet Sound", today, timeStamp, "I'm A audio log!!" );
	
		//Text Log test objects
		TextLog textLog1 = new TextLog();
		TextLog textLog2 = new TextLog(02);
		TextLog textLog3 = new TextLog(03,"abc-abc-abc", "Somthing Somthing Wordle", today, timeStamp, "I'm A text log!!" );

		//Photo Log test objects
		PhotoLog photoLog1 = new PhotoLog();
		PhotoLog photoLog2 = new PhotoLog(02);
		PhotoLog photoLog3 = new PhotoLog(03,"abc-abc-abc", "Kodak Moment", today, timeStamp, "I'm A photo log!!" );
		
		//Video Log test objects
		File videoFile1 = new VideoFile();
		File videoFile2 = new VideoFile("video02");
		File videoFile3 = new VideoFile("video03", ".mp4", 100);
		
		//Audio Log test objects
		File audioFile1 = new AudioFile();
		File audioFile2 = new AudioFile("Aduio02");
		File audioFile3 = new AudioFile("Audio03", ".mp3", 100);
		
		
		//Text Log test objects
		File textFile1 = new TextFile();
		File textFile2 = new TextFile();
		File textFile3 = new TextFile();

		//Photo Log test objects
		File photoFile1 = new PhotoFile();
		File photoFile2 = new PhotoFile();
		File photoFile3 = new PhotoFile();
		

		//outPutLog method used to call all super class methods for each log types
		outPutLog(vidLog1);
		outPutLog(vidLog2);
		outPutLog(vidLog3);

		outPutLog(audioLog1);
		outPutLog(audioLog2);
		outPutLog(audioLog3);
		
		outPutLog(textLog1);
		outPutLog(textLog2);
		outPutLog(textLog3);
		
		outPutLog(photoLog1);
		outPutLog(photoLog2);
		outPutLog(photoLog3);		
		

		//Specific child class functionality.
		System.out.println("Audio and video transcodeing and close caption functionality. \n");
		
		vidLog1.transcodeVideoFile(videoFile3);
		vidLog1.generateClosedCaption(videoFile3);
		
		audioLog1.transcodeAudioFile(audioFile3);
		audioLog1.generateClosedCaption(audioFile3);
		
		System.out.println("Textlog Translation functionality. \n");
		textLog1.translateText(textFile3, "French");
		
		System.out.println("PhotoLog Annotation functionality. \n");
		photoLog1.attachPhotoAnnotation(photoFile3, "Descriptive Text");	
	

	}
	
	public static void outPutLog(Log log){		

		File myFile = null;
		log.create();
		log.read();
		log.update();
		log.atttachFile(myFile);
		log.generateLogID();
		log.getUniqueShortCode();
		log.generateTimeStamp();
		log.delete();		
		
	}
	
	public static void outPutFile(File file){		
		
		file.create();
		file.read();
		file.update();
		file.copy();
		file.delete();
		
		
		
		
	}
	

}
