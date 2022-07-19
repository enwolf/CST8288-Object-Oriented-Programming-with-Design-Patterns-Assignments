package com.google.api;

import java.util.ArrayList;
import java.util.List;

import com.algonquin.loggy.IGoogleSpeech2TextAPI;

/* This is a very rough and ugly Google Speech2Text API pretender
 * for academic purposes non related to API programming nor Speech2Text
 * recognition or whatsoever.
 * 
 * But if you are curious on how the transcripts are actually done using
 * Google API you can see a real example at:
 * https://cloud.google.com/speech-to-text/docs/libraries#client-libraries-resources-java 
 */
public class GoogleSpeech2TextAPI implements IGoogleSpeech2TextAPI {

	List<String> transcriptAlternatives;
	String fileName;

	public GoogleSpeech2TextAPI() {
		transcriptAlternatives = new ArrayList<String>();
	}

	@Override
	public String instantiateClient() {
		return "speechClient";
	}

	@Override
	public String fileToMemory(String fileName) {
		this.fileName = fileName;
		return "audioBytes";
	}

	@Override
	public String buildSyncRecognizeRequestConfig() {
		return "config";
	}

	@Override
	public String buildSyncRecognizeRequestAudio() {
		return "audio";
	}

	@Override
	public void performSpeechRecognition(String config, String audio) {
		// Mock-up results.
		System.out.println("Performing Speech Recognition based on " + config + " for " + audio);
		transcriptAlternatives.add("<first transcript>");
		transcriptAlternatives.add("<second transcript>");
	}

	@Override
	public String getFirstTranscriptAlternative() {
		for (String result : transcriptAlternatives) {
			// Returns the first element.
			System.out.println("Returning " + result);
			return result + " for " + this.fileName;
		}
		return null;
	}

	@Override
	public List<String> getResultList() {
		return transcriptAlternatives;
	}

	@Override
	public String recognitionAudio() {
		return null;
	}

	@Override
	public void setRecognitionConfigParameters() {
		System.out.println("Set parameters");
	}
}
