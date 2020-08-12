package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void createComment(Comment comment){
        commentRepository.createComment(comment);
    }
    
    public List<Comment> getAllComments(Integer imageId, Integer userId) {
		return commentRepository.getCommentsForImgUser(imageId, userId);
    }
}
