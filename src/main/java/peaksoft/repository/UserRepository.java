package peaksoft.repository;


import peaksoft.entity.User;

import java.util.List;

public interface UserRepository {
    String signup(User user);

    User signInByUserId(User user);

    User findUserById(Long id);
    String updateUserById(Long id,User newUser);
    User getUserByUsername(String username);

    boolean deleteUserById(Long id);

    List<User> userProfile();


}