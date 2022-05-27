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
		
		System.out.println("Testing functionality of each child class of Log and there inherated methods and constructors. \n");
		
		//Video Log test objects
		VideoLog videoLog1 = new VideoLog();
		VideoLog videoLog2 = new VideoLog(02);
		VideoLog videoLog3 = new VideoLog(03,"abc-abc-abc", "Fancy Title!", today, timeStamp, "I'm a video log!!" );

		//Audio Log test objects
		AudioLog audioLog1 = new AudioLog();
		AudioLog audioLog2 = new AudioLog(02);
		AudioLog audioLog3 = new AudioLog(03,"abc-abc-abc", "Sweet Sound", today, timeStamp, "I'm a audio log!!" );
	
		//Text Log test objects
		TextLog textLog1 = new TextLog();
		TextLog textLog2 = new TextLog(02);
		TextLog textLog3 = new TextLog(03,"abc-abc-abc", "Somthing Somthing Wordle", today, timeStamp, "I'm a text log!!" );

		//Photo Log test objects
		PhotoLog photoLog1 = new PhotoLog();
		PhotoLog photoLog2 = new PhotoLog(02);
		PhotoLog photoLog3 = new PhotoLog(03,"abc-abc-abc", "Kodak Moment", today, timeStamp, "I'm a photo log!!" );
		
		//Video Log test objects
		File videoFile1 = new VideoFile();
		File videoFile2 = new VideoFile("videoFile02");
		File videoFile3 = new VideoFile("videoFile03", ".mp4", 250);
		
		//Audio Log test objects
		File audioFile1 = new AudioFile();
		File audioFile2 = new AudioFile("AduioFile02");
		File audioFile3 = new AudioFile("AudioFile03", ".mp3", 100);
		
		
		//Text Log test objects
		File textFile1 = new TextFile();
		File textFile2 = new TextFile("TextFile02");
		File textFile3 = new TextFile("TestFile03", ".txt", 15);

		//Photo Log test objects
		File photoFile1 = new PhotoFile();
		File photoFile2 = new PhotoFile("PhotoFile02");
		File photoFile3 = new PhotoFile("PhotoFile03", ".png", 75);
		

		//outPutLog method used to call all super class methods for each log types
		outPutLog(videoLog1);
		outPutLog(videoLog2);
		outPutLog(videoLog3);

		outPutLog(audioLog1);
		outPutLog(audioLog2);
		outPutLog(audioLog3);
		
		outPutLog(textLog1);
		outPutLog(textLog2);
		outPutLog(textLog3);
		
		outPutLog(photoLog1);
		outPutLog(photoLog2);
		outPutLog(photoLog3);
		
		//Testing child class functionality for children of File.java.
		System.out.println("Testing functionality of each child class of Log.java and file validation methods. \n");
		
		System.out.println("Validating Video Files:");
		videoLog3.validateFileSize(videoFile3);
		videoLog3.validateFileSize(videoFile1);
		videoLog3.validateFileType(videoFile3);
		videoLog3.validateFileType(videoFile1);
		
		System.out.println("\nValidating Audio Files:");
		audioLog3.validateFileSize(audioFile3);
		audioLog3.validateFileSize(audioFile1);
		audioLog3.validateFileType(audioFile3);
		audioLog3.validateFileType(audioFile1);
		
		System.out.println("\nValidating Text Files:");
		textLog3.validateFileSize(textFile3);
		textLog3.validateFileSize(textFile1);
		textLog3.validateFileType(textFile3);
		textLog3.validateFileType(textFile1);
		
		System.out.println("\nValidating Photo Files:");
		photoLog3.validateFileSize(photoFile3);
		photoLog3.validateFileSize(photoFile1);
		photoLog3.validateFileType(photoFile3);
		photoLog3.validateFileType(photoFile1);
		
		//Testing Specific child class functionality for children of Log.java.
		System.out.println("\nTesting AudioLog and VideoLog transcodeing and close caption functionality. \n");
		videoLog3.transcodeVideoFile(videoFile3);
		videoLog3.generateClosedCaption(videoFile3);
		
		System.out.println();
		audioLog3.transcodeAudioFile(audioFile3);
		audioLog3.generateClosedCaption(audioFile3);
		
		System.out.println("\nTesting Textlog Translation functionality. \n");
		textLog3.translateText(textFile3, "French");
		
		System.out.println("Testing PhotoLog Annotation functionality. \n");
		photoLog3.attachPhotoAnnotation(photoFile3, "Descriptive Text");
							
		//Testing child class functionality for children of File.java.
		System.out.println("Testing functionality of each child class of File.java and there inherated methods and constructors. \n");
		
		System.out.println("Video Files:\n");
		outPutFile(videoFile1);
		outPutFile(videoFile2);
		outPutFile(videoFile3);
		System.out.println("\nAudio Files:\n");
		outPutFile(audioFile1);
		outPutFile(audioFile2);
		outPutFile(audioFile3);
		System.out.println("\nText Files:\n");
		outPutFile(textFile1);
		outPutFile(textFile2);
		outPutFile(textFile3);
		System.out.println("\nPhoto Files:\n");
		outPutFile(photoFile1);
		outPutFile(photoFile2);
		outPutFile(photoFile3);		

	}
	
	//public static test methods for children of Log.java and File.java
	
	public static void outPutLog(Log log){		

		File myFile = null;
		System.out.println("********* LogFile *********\n");
		log.create();
		log.read();
		log.update();
		log.atttachFile(myFile);
		log.generateLogID();
		log.getUniqueShortCode();
		log.generateTimeStamp();
		log.delete();	
		System.out.println();
		
	}
	
	public static void outPutFile(File file){		
		System.out.println("--------- "+ file.getFileName()+ " --------\n");
		file.create();
		file.update();
		file.read();	
		file.copy();
		file.delete();
		System.out.println();
		
	}
}
