package peaksoft.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.User;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;


import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public static User corrent;


    @Override
    public String signup(User user) {
        return userRepository.signup(user);
    }

    @Override
    public User signInByUserId(User user) {
        corrent=userRepository.signInByUserId(user);
        return  user;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public String updateUserById(Long id, User newUser) {
        return userRepository.updateUserById(id,newUser);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }

    @Override
    public void save(User user) {
        userRepository.signup(user);
    }

    @Override
    public List<User> userProfile() {
        return userRepository.userProfile();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
