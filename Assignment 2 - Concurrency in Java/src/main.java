import java.util.UUID;

/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 2: Concurrency In Java
	Date: 2022-05-30  	
	Objective: To demonstrate principles Concurrency via multi-threading.
*/

public class main {

	public static void main(String[] args) {
		
		Recording myRecording = new Recording(UUID.randomUUID(),"TestFile", ".mp4", (long) 2000, "GCLOUD"  );
		CCWorker myWorker = new CCWorker(myRecording);
		myWorker.run();
	}

}
