/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 2: Concurrency In Java
	Date: 2022-05-29 - 	
	Objective: To demonstrate principles Concurrency via multi-threading.
*/

public class CCWorker implements Runnable{

	private final Recording RECORDING;
	private final String CLOUDSERVICE;
	

	//Without this constructor ensuring that FINAL VARIABLES were set I would have had to initialize both of them. 
	//Not a 100% sure if these need to be FINAL but I suspect we don't want there values to ever change while in a thread.
	public CCWorker(Recording RECORDING, String CLOUDSERVICE)
	{
		this.RECORDING = RECORDING;
		this.CLOUDSERVICE = CLOUDSERVICE;
		
	}	

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " Processing: " + RECORDING.getFileName() + " sending to " + CLOUDSERVICE + " to generate closed captions....."   );
		
	}			
	
	/*
	This method simulates the closed caption processing	the thread sleeps for the number of milliseconds = to the randomly generated file size 
	of the Recording Object. I also added three local variables to help with formating	out put and simulating attaching a file to the recording object.
		
	*/
	
	
	public void processRecording() {
		
		float seconds = this.getRECORDING().getFileSize() / 1000 ;
		String cloudServiceProvider;
		String ccFileName = "processedClosedCaption.srt";
	
		
		
		if (this.getCLOUDSERVICE().equals("AWS") )
			 cloudServiceProvider = "Amazone Web Services";
		else 
			 cloudServiceProvider = "Google Cloud";		
		
		try {
				Thread.sleep(500);
				System.out.println(cloudServiceProvider + " is start Closed Captioning generation, processing will be compleate in " + seconds + " seconds. Analyzing....."); 
				Thread.sleep(RECORDING.getFileSize());
				RECORDING.setClosedCatption(ccFileName);
				System.out.println("Processing compleate for: \nFile ID: " + RECORDING.getID() + "\nFile Name: " + RECORDING.getFileName() + "\nAttaching CC file: " + RECORDING.getClosedCatption() );
				
		}catch(InterruptedException e){
			System.out.println("wooops!!!");
			e.printStackTrace();
		}		
	}
	
	
	//GETTERS
	public String getCLOUDSERVICE() {
		return CLOUDSERVICE;
	}
	
	public Recording getRECORDING() {
		return RECORDING;
	}	
	
 
}//END OF CLASS
