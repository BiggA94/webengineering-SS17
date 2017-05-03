package de.uks.awe.webengineering.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post")
    public List<Post> getPostList() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/post/{id}")
    public Post getPost(@PathVariable String id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @RequestMapping(value = "/post/new", method = RequestMethod.PUT)
    public void addPost(@RequestParam("title") String title) {
        postService.createPost(title);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable String id) {
        postService.deletePost(id);
    }
}
