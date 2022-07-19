package com.algonquin.loggy;

public class CCAWSAdapter implements ICCAdapter {

	public CCAWSAdapter() {

	}

	@Override
	public void triggerClosedCaptioning(Recording recording) {

		AWSTranscribeProxy AWSProxyApi = new AWSTranscribeProxy();

		String ccFile = "";
		Long fileSize = recording.getFileSize();
		String rawFile = recording.getMediaFileMock();

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
