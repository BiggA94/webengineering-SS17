package de.uks.awe.webengineering.post;

import java.sql.Timestamp;

/**
 * Created by alexw on 03.05.2017.
 */
public class Post {
    
    private String id;
    private Timestamp timeOfCreation;
    private String content;

    public String getId() {
        return id;
    }

    public Post withId(String id) {
        this.id = id;
        return this;
    }

    public Timestamp getTimeOfCreation() {
        return timeOfCreation;
    }

    public Post withTimeOfCreation(Timestamp timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post withContent(String content) {
        this.content = content;
        return this;
    }
}
