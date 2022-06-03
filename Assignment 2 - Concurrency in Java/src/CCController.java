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
	private final ExecutorService CONTROLLER = Executors.newFixedThreadPool(CONCURRENT_THREAD_COUNT);
	
	CCController(){
		
	}

	public void processThread (Recording recording) {
				
				Runnable fileToProcess = new CCWorker(recording);				
				CONTROLLER.execute(fileToProcess);				
	}	
	
	public void shutDownController() {

		CONTROLLER.shutdown();
	}
	
}

