package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Image;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.repository.PostRepository;


import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepositoryImpl  implements PostRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String createPostWithImageAndLikes(Post post) {
        List<Image> images = post.getImages();
        if (images == null || images.isEmpty()) {
            throw new IllegalArgumentException("Post must have at least one image to be saved");
        }
        post.setLikes(new ArrayList<>());
        entityManager.persist(post);

        return "Post created successfully!";
    }

    @Override
    public Post findPostById(Long id) {
        try {
            return entityManager.find(Post.class, id);
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return  null;
    }
    @Override
    public String updatePostById(Long id, Post newPost) {
        try{
            Post post = entityManager.find(Post.class,id);
            post.setTitle(newPost.getTitle());
            post.setDescription(newPost.getDescription());
            entityManager.merge(post);

            return "updated successfully";
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return "failed";
    }

    @Override
    public void addUserToPost(Long postId, Long userId) {
        Post post = entityManager.find(Post.class, postId);
        if (post == null) {
            throw new EntityNotFoundException("Post with id " + postId + " not found");
        }
        User user = entityManager.find(User.class, userId);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + userId + " not found");
        }
        post.setUser(user);
        entityManager.merge(post);
    }

    @Override
    public void deleteById(Long Id) {
        try {
            Post post = entityManager.find(Post.class, Id);
            if (post != null) {
                entityManager.remove(post);
            } else {
                throw new EntityNotFoundException("Post with id " + Id + " not found");
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
    }
}