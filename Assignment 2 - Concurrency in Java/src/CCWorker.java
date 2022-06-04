/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 2: Concurrency In Java
	Date: 2022-05-30 - 	
	Objective: To demonstrate principles Concurrency via multi-threading.
*/

public class CCWorker implements Runnable{

	private final Recording RECORDING;	
	
	//Without this constructor ensuring that FINAL VARIABLES were set I would have had to initialize it. 
	//Not a 100% sure if these need to be FINAL but I suspect we don't want the values to ever change while any threads is running.
	
	public CCWorker(Recording RECORDING){
		this.RECORDING = RECORDING;		
	}	
	
	// This is what execute's when we run our thread. Consider this like main{} if that helps.
	
	@Override
	public void run() {
		
		System.out.println("\nCurrent Thread: " + Thread.currentThread().getName() + "\nProcessing: " + RECORDING.getFileName() + " sending to " + RECORDING.getEncoding() + " to generate closed captions....."   );
		processRecording();		
	}			
	
	 /*
	 * 
	 *	This method simulates the closed caption processing	the thread sleeps for the number of milliseconds = to the randomly generated file size 
	 *	of the Recording Object. I also added three local variables to help with formating output and simulating attaching a file to the recording object.
	 *
	 */
	
	public void processRecording(){
		
		String cloudServiceProvider;
		String ccFileName = "processedClosedCaption.srt";
					
		if (RECORDING.getEncoding().equals("AWS") )
			 cloudServiceProvider = "Amazon Web Services";
		else 
			 cloudServiceProvider = "Google Cloud";		
		
		try {		
			
			System.out.println("\n"+cloudServiceProvider + " has started closedCaptioningGeneration()\nAnalyzing.....");
			System.out.println("File ID: " + RECORDING.getID() + "\nFile Name: " + RECORDING.getFileName() + RECORDING.getFileType());			
			Thread.sleep(RECORDING.getFileSize());
			RECORDING.setClosedCatption(ccFileName);
			System.out.println("Processing Complete: " + RECORDING.getFileName() + RECORDING.getFileType() + "\nAttaching CC file: " + RECORDING.getClosedCatption() +"\nReleaseing Current Thread: " + Thread.currentThread().getName()+"\n");				
				
		}catch(InterruptedException e){
			
			e.printStackTrace();
		}		
	}	
	
	//GETTERS
	public Recording getRECORDING() {
		return RECORDING;
		
	}		
 
} //END OF CLASS
