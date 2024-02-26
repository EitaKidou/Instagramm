package peaksoft.service;


import peaksoft.entity.Image;
import peaksoft.entity.Post;

public interface PostService {
    Post findPostById(Long id);
    void save(Image image);

    String updatePostById(Long id, Post newPost);

    void addUserToPost(Long postId, Long userId);
    void deleteById(Long Id);

}
