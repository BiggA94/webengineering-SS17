package de.uks.awe.webengineering.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /*
    TODO
     */

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getComments() {
        Iterable<Comment> allComments = commentService.getAll();
        if(allComments == null || !allComments.iterator().hasNext()){
            return "EMPTY";
        }
        return allComments;
    }

    @PostMapping("/add")
    public String createComment(HttpServletRequest request, @RequestParam Long postId, @RequestBody String content) {
        Comment comment = commentService.createComment(postId, content);

        if (comment != null) {
            return "{\"url\": \"" + request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()) + "/api/comment/" + comment.getId() + "\"}";
        }
        return null;
    }
}
