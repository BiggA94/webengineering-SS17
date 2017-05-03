package de.uks.awe.webengineering.post;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Handle all CRUD operations for posts.
 */
@Service
public class PostService {
    private List<Post> posts = new LinkedList<>();

    /**
     * Retrieve the list of all posts.
     *
     * @return post list
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Retrieve the post created at a specific date
     *
     * @return post
     */
    public Post getPost(String id) {
        if (id == null) {
            return null;
        }
        for (Post post : posts) {
            if (id.equals(post.getId())) {
                return post;
            }
        }
        return null;
    }


    /**
     * Add a new post.
     *
     * @param post the post.
     */
    public void addPost(Post post) {
        if(post == null){
            return;
        }
        posts.add(post);
    }

    /**
     * Create a new post.
     *
     * @param title the post title.
     */
    public void createPost(String title) {
        if(title == null){
            return;
        }
        Post post = new Post();
        post.withContent(title);
        post.withTimeOfCreation(new Timestamp(System.currentTimeMillis()));
        // replaced later, when using persistence
        post.withId(UUID.randomUUID().toString());
        posts.add(post);
    }

    /**
     * Delete a Post specified by the id
     * @param id
     * @return
     */
    public boolean deletePost(String id) {
        if(id == null){
            return false;
        }
        for (Iterator<Post> iterator = posts.iterator(); iterator.hasNext();) {
            Post post = iterator.next();
            if (id.equals(post.getId())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
