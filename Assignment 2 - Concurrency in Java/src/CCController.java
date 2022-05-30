import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 2: Concurrency In Java
	Date: 2022-05-29 - 	
	Objective: To demonstrate principles Concurrency via multi-threading.
*/

public class CCController  {
	
	private final int CONCURRENT_THREAD_COUNT = 5;
	private ExecutorService controller = Executors.newFixedThreadPool(CONCURRENT_THREAD_COUNT);
	
	
	
	CCController(){
		
	}
	
	
	
	
	public void processThread (Recording recording, String encodingService) {
		
				
				Runnable fileToProcess = new CCWorker(recording);

				//TODO Finish writing this method. Reference the Spooler print out
				//Then complete this task and set up your proper test case in main.java
				//You might not need the staring in the processThread signature.
		
				
		
		
		
		controller.execute(null);
		
		
		
	}
	
	
	
	

	
	
	
	
	
}
