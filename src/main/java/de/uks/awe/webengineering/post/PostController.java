package de.uks.awe.webengineering.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP endpoint for a post-related HTTP requests.
 */
@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "")
    public Iterable<Post> getPostList(@RequestParam(value = "ordered", required = false, defaultValue = "false") boolean ordered) {
        if (ordered) {
            return postService.getPostsOrderedByTimeOfCreation();
        }
        return postService.getPosts();
    }

    @RequestMapping(value = "/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @RequestMapping(value = "/new", method = RequestMethod.PUT)
    public String addPost(HttpServletRequest request, @RequestParam String title, @RequestParam String content) {
        Post post = postService.createPost(title, content);
        // currently no need for a JsonObject, or another Class, thus per Hand:
        return "{\"url\": \"" + request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()) + "/api/post/" + post.getId() + "\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
