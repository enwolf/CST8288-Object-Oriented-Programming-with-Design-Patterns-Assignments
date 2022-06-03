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
	
	private int concurrentThreadCount = 5;
	private ExecutorService controller = Executors.newFixedThreadPool(concurrentThreadCount);
	
	CCController(){
		
	}
	
	CCController(int concurrentThreadCount){
		this.concurrentThreadCount = concurrentThreadCount;
	}

	public void processThread (Recording recording) {
		//CCWorker is a Runnable Object as it implements the Runnable interface.		
		CCWorker fileToProcess = new CCWorker(recording);				
		controller.execute(fileToProcess);				
	}	
	
	public void shutdown(int i) {
		
		controller.shutdown();
		//Waits for all threads to be shutdown before printing final sys.out msg
		while (!controller.isTerminated()){			
		
		}
		
		System.out.println("Closed Caption Procesing Compleate...\nAll " + i + "# Threads Resolved...\nShutting Down.... ");		
	}	 

}//END OF CLASS

