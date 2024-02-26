package peaksoft.repository;
import peaksoft.entity.Comment;

import java.util.List;

public interface CommentRepository {
    String saveComment (Comment comment);
    List<Comment> findAllCommentByPostId(Long postId);

    String deleteCommentById (Long id);
}
