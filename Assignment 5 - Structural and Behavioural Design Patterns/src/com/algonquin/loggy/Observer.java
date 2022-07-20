package com.algonquin.loggy;

public interface Observer {

	public void update(String ccFile, String fileName, Long fileSize);

}
