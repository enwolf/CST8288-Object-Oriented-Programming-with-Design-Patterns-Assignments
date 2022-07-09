package com.algonquin.loggy;

import java.util.Arrays;
import java.util.List;

public class ImageLog extends Log {

    public static final List<String> contentTypes = Arrays.asList("PNG", "JPG", "GIF", "SVG");

    public ImageLog() {
    }

    public ImageLog(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isValidContentType(String type) {
        return ImageLog.contentTypes.contains(type);
    }

    @Override
    public void attachFile(String name, String type, String content, Long size) throws Exception {
        super.attachFile(name, type, content, size);
        System.out.println("Attaching " + name + " to " + this.getName());
        this.setAttachment(new ImageFile(name, type, content, size));
        ImageFile attachment = (ImageFile) this.getAttachment();
        attachment.postProcess();
    }

}
