package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VideoLog extends Log {

    public static final List<String> contentTypes = Arrays.asList("MP4", "MPG", "MPEG", "M4V");

    /**
     *
     */
    public VideoLog() {
    }

    /**
     *
     */
    public VideoLog(String name, String description) {
        super(name, description);
    }

    /**
     *
     */
    public VideoLog(String name, String description, Date date) {
        super(name, description, date);
    }

    /**
     *
     */
    @Override
    public boolean isValidContentType(String type) {
        return VideoLog.contentTypes.contains(type);
    }

    /**
     * @throws Exception
     *
     */
    @Override
    public void attachFile(String name, String type, String content, Long size) throws Exception {
        super.attachFile(name, type, content, size);
        System.out.println("Attaching " + name + " to " + this.getName());
        this.setAttachment(new VideoFile(name, type, content, size));
        VideoFile attachment = (VideoFile) this.getAttachment();
        attachment.postProcess();
    }

}
