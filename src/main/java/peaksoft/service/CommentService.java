package peaksoft.service;



import peaksoft.entity.Comment;

import java.util.List;

public interface CommentService {
    String saveComment (Comment comment);
    List<Comment> findAllCommentByPostId(Long postId);

    String deleteCommentById (Long id);
}
