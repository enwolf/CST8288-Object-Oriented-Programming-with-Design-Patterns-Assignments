/**
 *
 */
package com.algonquin.loggy;

/**
 * @author jesus
 *
 */
public class ImageFile extends File {

    /**
     * @param name
     * @param type
     * @param content
     * @param size
     */
    public ImageFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        System.out.println("This image file is going to be described");
    }

}
