package com.algonquin.loggy;

public class Main {

    public static void main(String[] args) {

        try {
            // Mock-up logs with non-supported content type
            mockLog(new ImageLog("first log", "Monday May 3, I had to wake up early"), new ImageFile("image.tif", "TIF", "******", Long.valueOf(1024)));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
        }

        try {
            // Mock-up logs with incorrect attachment
            mockLog(new TextLog("fourth log", "And even later, I need to have lunch"), new TextFile("eating.png", "PNG", "******", Long.valueOf(1024)));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
        }

        try {
            // Mock-up logs with correct attachment
            mockLog(new ImageLog("first log", "Monday May 4, I had to wake up early"), new ImageFile("image.png", "PNG", "******", Long.valueOf(1024)));
            mockLog(new ImageLog("second log", "Few minutes later, I had my first cup of coffee"), new ImageFile("coffee.png", "PNG", "******", Long.valueOf(1024)));
            mockLog(new VideoLog("third log", "Few minutes later, I am going for a ride"), new VideoFile("biking1.mp4", "MP4", "******", Long.valueOf(1024)));
            mockLog(new TextLog("fourth log", "And even later, I need to have lunch"), new TextFile("recipie.txt", "TXT", "******", Long.valueOf(1024)));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
        }

    }

    private static void mockLog(Log log, File file) throws Exception {
        System.out.println(">>> New log (" + log.toString() + ")");
        log.attachFile(file);
        log.create();
        System.out.println("\n");
    }
}
