package com.algonquin.loggy;

public class Main {

	public static void main(String[] args) {
		LogBuilder logBuilder = new LogBuilder();

		try {
			// Mock-up logs with non-supported content type
			mockLog(logBuilder.setUUID().setShortCode().setName("first log")
					.setDescription("Monday May 3, I had to wake up early").setDate().setFile(null).createImageLog(),
					new ImageFile("image.tif", "TIF", "******", Long.valueOf(1024)));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n\n");

		}

		try {
			// Mock-up logs with incorrect attachment
			mockLog(logBuilder.setUUID().setShortCode().setName("fourth log")
					.setDescription("And even later, I need to have lunch").setDate().setFile(null).createTextLog(),
					new TextFile("eating.png", "PNG", "******", Long.valueOf(1024)));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n\n");

		}

		try {
			// Mock-up logs with correct attachment
			mockLog(logBuilder.setUUID().setShortCode().setName("first log")
					.setDescription("Monday May 4, I had to wake up early").setDate().setFile(null).createImageLog(),
					new ImageFile("image.png", "PNG", "******", Long.valueOf(1024)));
			mockLog(logBuilder.setUUID().setShortCode().setName("second log")
					.setDescription("Few minutes later, I had my first cup of coffee").setDate().setFile(null)
					.createImageLog(), new ImageFile("coffee.png", "PNG", "******", Long.valueOf(1024)));

			mockLog(logBuilder.setUUID().setShortCode().setName("third log")
					.setDescription("Few minutes later, I am going for a ride").setDate().setFile(null)
					.createVideoLog(), new VideoFile("biking1.mp4", "MP4", "******", Long.valueOf(1024)));

			mockLog(logBuilder.setUUID().setShortCode().setName("fourth log")
					.setDescription("And even later, I need to have lunch").setDate().setFile(null).createTextLog(),
					new TextFile("recipie.txt", "TXT", "******", Long.valueOf(1024)));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n\n");

		}

	}

	private static void mockLog(Log log, File file) throws Exception {
		System.out.println(">>> New log (" + log.toString() + ")");
		log.attachFile(file);
		System.out.println("\n");
	}
}
