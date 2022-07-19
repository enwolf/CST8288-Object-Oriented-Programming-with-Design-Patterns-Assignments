package com.algonquin.loggy;

import com.aws.api.AWSTranscribeAPI;

public class AWSTranscribeProxy implements IAWSTranscribeAPI {

	private AWSTranscribeAPI AWSProxyObj = new AWSTranscribeAPI();

	@Override
	public String clientCreate() {
		return AWSProxyObj.clientCreate();
	}

	@Override
	public String getStreamFromFile(String audioFileName) {
		return AWSProxyObj.getStreamFromFile(audioFileName);
	}

	@Override
	public void startStreamTranscription(String client, String stream) {
		AWSProxyObj.startStreamTranscription(client, stream);
	}

	@Override
	public String getResult() {
		return AWSProxyObj.getResult();
	}

	@Override
	public void clientClose(String client) {
		AWSProxyObj.clientClose(client);
	}

}
