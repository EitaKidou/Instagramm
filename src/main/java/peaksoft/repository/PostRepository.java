package peaksoft.repository;


import peaksoft.entity.Post;

public interface PostRepository {
    String createPostWithImageAndLikes(Post post);

    Post findPostById(Long id);

    String updatePostById(Long id, Post newPost);

    void addUserToPost(Long postId, Long userId);

    void deleteById(Long Id);
}
