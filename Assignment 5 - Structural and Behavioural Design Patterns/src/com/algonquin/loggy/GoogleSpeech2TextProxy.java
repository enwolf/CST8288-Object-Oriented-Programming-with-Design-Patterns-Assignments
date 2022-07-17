package com.algonquin.loggy;

import com.google.api.GoogleSpeech2TextAPI;

public class GoogleSpeech2TextProxy {

	private GoogleSpeech2TextAPI googleApiObj = new GoogleSpeech2TextAPI();

	public String instantiateClient() {
		return googleApiObj.instantiateClient();
	}

	public String fileToMemory(String fileName) {
		return googleApiObj.fileToMemory(fileName);
	}

	public String buildSyncRecognizeRequestConfig() {
		return googleApiObj.buildSyncRecognizeRequestConfig();
	}

	public String buildSyncRecognizeRequestAudio() {
		return googleApiObj.buildSyncRecognizeRequestAudio();
	}

	public void performSpeechRecognition(String config, String audio) {
		googleApiObj.performSpeechRecognition(config, audio);
	}

	public String getFirstTranscriptAlternative() {
		return googleApiObj.getFirstTranscriptAlternative();
	}

}
