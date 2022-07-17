package com.algonquin.loggy;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		int maxmockups = 1; // The number of mock-ups to be generated.

		List<Recording> recordings = new LinkedList<Recording>();
		// Set the mock-up recordings.
		for (int i = 0; i < maxmockups; i++) {
			String fileName = "recording-" + String.valueOf(i) + ".mp4";
			Long fileSize = (long) (Math.random() * (1024L - 1L));
			recordings.add(new Recording(UUID.randomUUID(), fileName, fileSize));
		}

		// Enqueue recordings for closed captioning.
		CCSpooler spooler = new CCSpooler();
		recordings.forEach((recording) -> {
			spooler.enqueue(recording);
		});

		spooler.shutdown();
	}

}
