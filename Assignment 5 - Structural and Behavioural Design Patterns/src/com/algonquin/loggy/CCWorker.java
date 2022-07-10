/**
 * 
 */
package com.algonquin.loggy;

import com.aws.api.AWSTranscribeAPI;
import com.google.api.GoogleSpeech2TextAPI;

/**
 * @author jesus
 *
 */
public class CCWorker implements Runnable {
	private final Recording recording;

	// Constructor to assign a message when creating a new thread
	public CCWorker(Recording recording) {
		this.recording = recording;
	}

	@Override
	/**
	 *
	 */
	public void run() {
		System.out.println(
				Thread.currentThread().getName() + " (Start closed captioning) recording = " + recording.getFileName());
		// Trigger CC using the local methods.
		triggerGoogleClosedCaptioning();
		triggerAWSClosedCaptioning();

		// Trigger CC using the adapter methods.
		// TODO

		System.out.println(Thread.currentThread().getName() + " (End closed captioning)");
	}

	private void triggerGoogleClosedCaptioning() {
		String rawFile = recording.getMediaFileMock();
		Long fileSize = recording.getFileSize();
		GoogleSpeech2TextAPI api = new GoogleSpeech2TextAPI();
		String ccFile = "";
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		try {
			// Simulate the delay.
			Thread.sleep(fileSize);
			// MockUp transcript process.
			String speechClient = api.instantiateClient();
			String audioBytes = api.fileToMemory(rawFile);
			String config = api.buildSyncRecognizeRequestConfig();
			String audio = api.buildSyncRecognizeRequestAudio();
			api.performSpeechRecognition(config, audio);
			String transcript = api.getFirstTranscriptAlternative();
			ccFile = transcript;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recording.setCcFileMock(ccFile);
		System.out.println(ccFile + " processed using GoogleSpeech2TextAPI");
	}
	
	private void triggerAWSClosedCaptioning() {
		String rawFile = recording.getMediaFileMock();
		Long fileSize = recording.getFileSize();
		AWSTranscribeAPI api = new AWSTranscribeAPI();
		String ccFile = "";
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		try {
			// Simulate the delay.
			Thread.sleep(fileSize);
			// MockUp transcript process.
			String client = api.clientCreate();
			String stream = api.getStreamFromFile(rawFile);
			api.startStreamTranscription(client, stream);
			String transcript = api.getResult();
			api.clientClose(client);
			ccFile = transcript;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recording.setCcFileMock(ccFile);
		System.out.println(ccFile + " processed using AWSTranscribeAPI");
	}

}
