package peaksoft.service;


import peaksoft.entity.User;

import java.util.List;

public interface UserService {
    String signup(User user);
    User signInByUserId(User user);

    User findUserById(Long id);
    String updateUserById(Long id,User newUser);

    boolean deleteUserById(Long id);
    void save(User user);

    List<User> userProfile();

    User getUserByUsername(String username);
}
