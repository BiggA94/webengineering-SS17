package de.uks.awe.webengineering.comment;

import de.uks.awe.webengineering.post.Post;
import de.uks.awe.webengineering.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;


    public Comment createComment(Long postId, String content){
        Post post = postService.getPost(postId);

        if(post != null){
            Comment comment = new Comment();
            comment.withPost(post);

        }

        return null;
    }

    public Comment getComment(Long id){
        return commentRepository.findOne(id);
    }

    public Iterable<Comment> getAll() {
        return commentRepository.findAll();
    }
}
