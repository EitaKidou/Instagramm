package peaksoft.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Image;
import peaksoft.entity.Post;
import peaksoft.repository.PostRepository;
import peaksoft.service.PostService;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public Post findPostById(Long id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void save(Image image) {

    }

    @Override
    public String updatePostById(Long id, Post newPost) {
        return postRepository.updatePostById(id,newPost);
    }

    @Override
    public void addUserToPost(Long postId, Long userId) {
        postRepository.addUserToPost(postId,userId);
    }

    @Override
    public void deleteById(Long Id) {
        postRepository.deleteById(Id);
    }
}