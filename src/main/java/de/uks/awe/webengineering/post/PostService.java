package de.uks.awe.webengineering.post;

import de.uks.awe.webengineering.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Handle all CRUD operations for posts.
 */
@Service
@Transactional
public class PostService {
    @Autowired
    private PostRepository posts;

    @Autowired
    private UserService userService;

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
    public Post createPost(String title, String content) {
        if (title == null) {
            return null;
        }
        Post post = new Post();
        post.withTitle(title);
        post.withContent(content);
        post.withAuthor(userService.getCurrentUser());
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

    /**
     * Return All the posts ordered by the time of Creation
     *
     * @return posts ordered by timeOfCreation
     */
    public Iterable<Post> getPostsOrderedByTimeOfCreation() {
        return posts.getAllByIdNotNullOrderByTimeOfCreation();
    }
}
