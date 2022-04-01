package com.edu.nbu.fan.spring.leak;

/**
 * @author laoshi . hua
 * @version 1.0 2022/4/1-5:23 PM
 * @since 1.0
 */
public class Greeting {
    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
