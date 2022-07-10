package com.aws.api;

import java.util.ArrayList;
import java.util.List;

/* This is a very rough and ugly AWS Transcribe API pretender
 * for academic purposes non related to API programming nor Speech2Text
 * recognition or whatsoever.
 * 
 * But if you are curious on how the transcripts are actually done using
 * AWS API you can find real examples at:
 * https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/javav2/example_code/transcribe 
 */
public class AWSTranscribeAPI {

	List<String> transcript;
	String fileName;

	public AWSTranscribeAPI() {
		transcript = new ArrayList<String>();
	}

	public String getStreamFromFile(String audioFileName) {
		this.fileName = audioFileName;
		return "streamFromFile";
	}

	public void startStreamTranscription(String client, String stream) {
		System.out.println(client + " is starting streaming " + stream);
		transcript.add("<transcript> for " + this.fileName);
		for (int i = 1; i <= 5; i++) {
			transcript.add("line-" + i);
		}
	}

	public String getResult() {
		String transcriptString = "";

		for (String s : transcript) {
			transcriptString += s + "\t";
		}
		return transcriptString;
	}

	public String clientCreate() {
		return "client";
	}

	public void clientClose(String client) {
		System.out.println("Closing " + client);
	}
}
