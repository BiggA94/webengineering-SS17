package de.uks.awe.webengineering.post;

import de.uks.awe.webengineering.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexw on 03.05.2017.
 */
@Entity
public class Post {
    public static final int TITLE_LENGTH = 1024;

    @Id
    @GeneratedValue
    private Long id;

    @Column(insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfCreation;

    @ManyToOne(optional = false)
    private User author;

    @Column(length = Post.TITLE_LENGTH)
    private String title;

    public String getTitle() {
        return title;
    }

    public Post withTitle(String title) {
        this.title = title;
        return this;
    }

    private String content;

    public Post() {
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

    @PrePersist
    private void setTimeOfCreation() {
        this.withTimeOfCreation(new Date());
    }
}
