package com.algonquin.loggy;

public class File implements Processable {

    private String name;
    private String type;
    private String content;
    private Long size;

    public File() {
    }

    public File(String name, String type, String content, Long size) {
        this.name = name;
        this.type = type;
        this.content = content;
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public void postProcess() {
        System.out.println("Default post processing");
    }

}
