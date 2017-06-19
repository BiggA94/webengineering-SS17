package de.uks.awe.webengineering.comment;

import de.uks.awe.webengineering.post.Post;
import de.uks.awe.webengineering.user.User;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by alexw on 27.05.2017.
 */

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User author;
    private String content;
    @Column(insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfCreation;

    @ManyToOne(optional = false)
    private Post post;

    public Post getPost() {
        return post;
    }

    public Comment withPost(Post post) {
        this.post = post;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment withAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment withContent(String content) {
        this.content = content;
        return this;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public Comment withTimeOfCreation(Date timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
        return this;
    }

    @PrePersist
    private void setTimeOfCreation() {
        this.withTimeOfCreation(new Date());
    }

    public long getId() {
        return id;
    }
}
