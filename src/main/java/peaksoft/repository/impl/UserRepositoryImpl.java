package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.User;
import peaksoft.repository.UserRepository;


import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepositoryImpl  implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public String signup(User user) {
        entityManager.persist(user);
        return "saved";
    }

    @Override
    public User signInByUserId(User user) {
        User foundUser =findUserById(Long.valueOf(user.getUser_name()));

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {

            System.out.println("User signed in successfully: " + foundUser);
        } else {

            System.out.println("Incorrect username or password");
        }return foundUser;
    }

    @Override
    public User findUserById(Long id) {
        try {

            return entityManager.find(User.class, id);
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return null;
    }
    @Override
    public String updateUserById(Long id, User newUser) {
        try {
            User user = findUserById(id);
            user.setUser_name(newUser.getUser_name());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setPhone_number(newUser.getPhone_number());
            entityManager.merge(user);
            return "updated successfully";
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return "failed";
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.user_name = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public boolean deleteUserById(Long id) {
        try {
            entityManager.remove(entityManager.find(User.class, id));
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public List<User> userProfile() {
        return entityManager.createQuery("select s  from User s ",User.class).getResultList();
    }
}