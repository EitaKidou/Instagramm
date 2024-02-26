package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Comment;
import peaksoft.entity.Like;
import peaksoft.entity.Post;
import peaksoft.repository.CommentRepository;


import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveComment(Comment comment) {
        Post post = entityManager.find(Post.class, comment.getPost().getId());
        if (post == null) {
            throw new EntityNotFoundException("Post with id " + comment.getPost().getId() + " not found");
        }
        comment.setLists(new ArrayList<>());
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        post.setComments(comments);
        entityManager.persist(post);

        return "Comment saved successfully!";
    }

    @Override
    public List<Comment> findAllCommentByPostId(Long postId) {
        return entityManager.createQuery("select c from Comment c where c.post.id = :postId", Comment.class)
                .setParameter("postId", postId).getResultList();
    }

    @Override
    public String deleteCommentById(Long id) {

        Comment comment = entityManager.find(Comment.class, id);
        if (comment == null) {
            throw new EntityNotFoundException("Comment with id " + id + " not found");
        }
        List<Like> likes = comment.getLists();
        for (Like like : likes) {
            entityManager.remove(like);
        }
        entityManager.remove(comment);

        return "Comment deleted successfully!";
    }
}