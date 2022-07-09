package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AudioLog extends Log {

    public static final List<String> contentTypes = Arrays.asList("MP3", "WAV", "AAC");

    public AudioLog() {
    }

    public AudioLog(String name, String description) {
        super(name, description);
    }

    public AudioLog(String name, String description, Date date) {
        super(name, description, date);
    }

    @Override
    public boolean isValidContentType(String type) {
        return AudioLog.contentTypes.contains(type);
    }

    @Override
    public void attachFile(String name, String type, String content, Long size) throws Exception {
        super.attachFile(name, type, content, size);
        System.out.println("Attaching " + name + " to " + this.getName());
        this.setAttachment(new AudioFile(name, type, content, size));
        AudioFile attachment = (AudioFile) this.getAttachment();
        attachment.postProcess();
    }

}
