package com.algonquin.loggy;

public class CCGoogleAdapter implements ICCAdapter {

	public CCGoogleAdapter() {

	}

	@Override
	public void triggerClosedCaptioning(Recording recording) {

		GoogleSpeech2TextProxy googleProxyAPI = new GoogleSpeech2TextProxy();

		String ccFile = "";
		Long fileSize = recording.getFileSize();
		String rawFile = recording.getMediaFileMock();

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

}
