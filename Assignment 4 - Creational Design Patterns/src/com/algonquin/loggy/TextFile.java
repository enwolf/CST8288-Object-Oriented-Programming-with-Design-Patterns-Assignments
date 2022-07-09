/**
 *
 */
package com.algonquin.loggy;

/**
 * @author jesus
 *
 */
public class TextFile extends File {

    /**
     *
     */
    public TextFile() {
    }

    /**
     * @param name
     * @param type
     * @param content
     * @param size
     */
    public TextFile(String name, String type, String content, Long size) {
        super(name, type, content, size);
    }

    /**
     *
     */
    @Override
    public void postProcess() {
        super.postProcess();
        // trigger translation
        System.out.println("This text file is going to be translated");
    }

}
