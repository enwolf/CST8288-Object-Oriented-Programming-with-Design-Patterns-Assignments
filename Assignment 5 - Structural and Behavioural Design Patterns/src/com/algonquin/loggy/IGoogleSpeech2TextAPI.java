package com.algonquin.loggy;

import java.util.List;

public interface IGoogleSpeech2TextAPI {

	public String instantiateClient();

	public String fileToMemory(String fileName);

	public String buildSyncRecognizeRequestConfig();

	public String buildSyncRecognizeRequestAudio();

	public void performSpeechRecognition(String config, String audio);

	public String getFirstTranscriptAlternative();

	public List<String> getResultList();

	public String recognitionAudio();

	public void setRecognitionConfigParameters();
}
