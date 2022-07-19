package com.algonquin.loggy;

import java.util.List;

import com.google.api.GoogleSpeech2TextAPI;

public class GoogleSpeech2TextProxy implements IGoogleSpeech2TextAPI {

	private GoogleSpeech2TextAPI googleApiObj = new GoogleSpeech2TextAPI();

	@Override
	public String instantiateClient() {
		return googleApiObj.instantiateClient();
	}

	@Override
	public String fileToMemory(String fileName) {
		return googleApiObj.fileToMemory(fileName);
	}

	@Override
	public String buildSyncRecognizeRequestConfig() {
		return googleApiObj.buildSyncRecognizeRequestConfig();
	}

	@Override
	public String buildSyncRecognizeRequestAudio() {
		return googleApiObj.buildSyncRecognizeRequestAudio();
	}

	@Override
	public void performSpeechRecognition(String config, String audio) {
		googleApiObj.performSpeechRecognition(config, audio);
	}

	@Override
	public String getFirstTranscriptAlternative() {
		return googleApiObj.getFirstTranscriptAlternative();
	}

	@Override
	public List<String> getResultList() {
		return googleApiObj.getResultList();
	}

	@Override
	public String recognitionAudio() {

		return googleApiObj.recognitionAudio();
	}

	@Override
	public void setRecognitionConfigParameters() {
		googleApiObj.setRecognitionConfigParameters();

	}

}
