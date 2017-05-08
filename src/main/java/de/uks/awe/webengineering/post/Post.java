package de.uks.awe.webengineering.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by alexw on 03.05.2017.
 */
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private Date timeOfCreation;
    private String content;

    public Post() {
        timeOfCreation = new Date();
    }

    public Long getId() {
        return id;
    }

    public Post withId(Long id) {
        this.id = id;
        return this;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public Post withTimeOfCreation(Date timeOfCreation) {
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
