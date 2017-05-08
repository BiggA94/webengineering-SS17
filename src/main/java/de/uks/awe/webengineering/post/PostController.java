package de.uks.awe.webengineering.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post")
    public Iterable<Post> getPostList() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @RequestMapping(value = "/post/new", method = RequestMethod.PUT)
    public String addPost(HttpServletRequest request, @RequestParam("title") String title) {
        Post post = postService.createPost(title);
        // currently no need for a JsonObject, or another Class, thus per Hand:
        return "{\"url\": \"" + request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()) + "/post/" + post.getId() + "\"}";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
