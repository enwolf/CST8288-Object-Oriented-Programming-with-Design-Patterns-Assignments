package com.algonquin.loggy;

import com.aws.api.AWSTranscribeAPI;

public class AWSTranscribeProxy {

	private AWSTranscribeAPI AWSProxyObj = new AWSTranscribeAPI();

	public String clientCreate() {
		return AWSProxyObj.clientCreate();
	}

	public String getStreamFromFile(String audioFileName) {
		return AWSProxyObj.getStreamFromFile(audioFileName);
	}

	public void startStreamTranscription(String client, String stream) {
		AWSProxyObj.startStreamTranscription(client, stream);
	}

	public String getResult() {
		return AWSProxyObj.getResult();
	}

	public void clientClose(String client) {
		AWSProxyObj.clientClose(client);
	}

}
