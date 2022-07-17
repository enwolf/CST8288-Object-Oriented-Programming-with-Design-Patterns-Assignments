package com.algonquin.loggy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CCSpooler {
	private final ExecutorService executor;

	public CCSpooler() {
		// creating a pool of 5 threads
		this.executor = Executors.newFixedThreadPool(5);
	}

	public void enqueue(Recording recording) {
		Runnable worker = new CCWorker(recording);
		// calling execute method of ExecutorService
		executor.execute(worker);
	}

	public void shutdown() {
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
