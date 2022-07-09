/**
 *
 */
package com.algonquin.loggy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author jesus
 *
 */
public class TextLog extends Log {

    public static final List<String> contentTypes = Arrays.asList("DOC", "TXT", "PDF");

    /**
     *
     */
    public TextLog() {
    }

    /**
     * @param name
     * @param description
     */
    public TextLog(String name, String description) {
        super(name, description);
    }

    /**
     * @param name
     * @param description
     * @param date
     */
    public TextLog(String name, String description, Date date) {
        super(name, description, date);
    }

    /**
     *
     */
    @Override
    public boolean isValidContentType(String type) {
        return TextLog.contentTypes.contains(type);
    }

    /**
     * @throws Exception
     *
     */
    @Override
    public void attachFile(String name, String type, String content, Long size) throws Exception {
        super.attachFile(name, type, content, size);
        System.out.println("Attaching " + name + " to " + this.getName());
        this.setAttachment(new TextFile(name, type, content, size));
        TextFile attachment = (TextFile) this.getAttachment();
        attachment.postProcess();

    }

}
