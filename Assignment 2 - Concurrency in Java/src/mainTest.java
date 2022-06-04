import java.util.List;
import java.util.LinkedList;
import java.util.UUID;

/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 2: Concurrency In Java
	Date: 2022-05-30  	
	Objective: To demonstrate principles Concurrency via multi-threading.
*/

public class mainTest{
			
	public static void main(String[] args) {
			
		int numberOfThreads = 15;
		
		CCController controller = new  CCController();		
		//List to hold Recording Generated
		
		List<Recording> recordingList = new LinkedList<Recording>();
		
		//Loop to generating recording object and store as Linked List
		for (int i = 1; i < numberOfThreads; i++) {
			
			String fileName = "Recording_" + String.valueOf(i);
			Long fileSize = (long) (Math.random() * (3024L - 1L));
			String fileType = ".mp4";
			String CCEncodingService ="";
						
			if(i % 2 == 0){				
				CCEncodingService = "GCloud";
			}else{				
				CCEncodingService = "AWS";				
			}
			
			recordingList.add(new Recording(UUID.randomUUID(), fileName, fileType, fileSize, CCEncodingService));
		}
				
		//For each loop using lambda notation
		recordingList.forEach((recording) -> {			
			controller.processThread(recording);			
		});
			controller.shutdown(numberOfThreads);
			
	}
}
