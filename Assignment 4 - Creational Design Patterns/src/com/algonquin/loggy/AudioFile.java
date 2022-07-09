package com.algonquin.loggy;

public class AudioFile extends File {

    /**
     *
     */
    public AudioFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        System.out.println("This audio file is going to be transcoded and then closed captioned");
    }

}
