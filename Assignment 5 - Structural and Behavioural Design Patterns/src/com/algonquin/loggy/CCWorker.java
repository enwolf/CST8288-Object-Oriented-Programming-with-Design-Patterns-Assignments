package com.algonquin.loggy;

public class CCWorker implements Runnable {
	private final Recording recording;

	// Constructor to assign a message when creating a new thread
	public CCWorker(Recording recording) {
		this.recording = recording;
	}

	@Override
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
		GoogleSpeech2TextProxy googleProxyAPI = new GoogleSpeech2TextProxy();
		String ccFile = "";
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		try {
			// Simulate the delay.
			Thread.sleep(fileSize);
			// MockUp transcript process.
			String speechClient = googleProxyAPI.instantiateClient();
			String audioBytes = googleProxyAPI.fileToMemory(rawFile);
			String config = googleProxyAPI.buildSyncRecognizeRequestConfig();
			String audio = googleProxyAPI.buildSyncRecognizeRequestAudio();
			googleProxyAPI.performSpeechRecognition(config, audio);
			String transcript = googleProxyAPI.getFirstTranscriptAlternative();
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
		AWSTranscribeProxy AWSProxyApi = new AWSTranscribeProxy();
		String ccFile = "";
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		try {
			// Simulate the delay.
			Thread.sleep(fileSize);
			// MockUp transcript process.
			String client = AWSProxyApi.clientCreate();
			String stream = AWSProxyApi.getStreamFromFile(rawFile);
			AWSProxyApi.startStreamTranscription(client, stream);
			String transcript = AWSProxyApi.getResult();
			AWSProxyApi.clientClose(client);
			ccFile = transcript;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recording.setCcFileMock(ccFile);
		System.out.println(ccFile + " processed using AWSTranscribeAPI");
	}

}
