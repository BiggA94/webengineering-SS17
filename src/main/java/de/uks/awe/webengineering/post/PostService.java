package de.uks.awe.webengineering.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository posts;

    private AtomicLong atomicLong;

    public PostService() {
        atomicLong = new AtomicLong();
    }

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public Iterable<Post> getPosts() {
        return posts.findAll();
    }

    /**
     * Retrieve the post created at a specific date
     *
     * @return post
     */
    public Post getPost(Long id) {
        return posts.findOne(id);
    }


    /**
     * Add a new post.
     *
     * @param post the post.
     */
    public void addPost(Post post) {
        posts.save(post);
    }

    /**
     * Create a new post.
     *
     * @param title the post title.
     * @return the newly created post
     */
    public Post createPost(String title) {
        if (title == null) {
            return null;
        }
        Post post = new Post();
        post.withContent(title);
        posts.save(post);
        return post;
    }

    /**
     * Delete a Post specified by the id
     *
     * @param id
     */
    public void deletePost(Long id) {
        posts.delete(id);
    }
}
