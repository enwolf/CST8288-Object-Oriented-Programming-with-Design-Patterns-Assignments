/**
 *
 */
package com.algonquin.loggy;

/**
 * @author jesus
 *
 */
public class VideoFile extends File {

    /**
     * @param name
     * @param type
     * @param content
     * @param size
     */
    public VideoFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        System.out.println("This video file is going to be closed captioned");
    }

}
