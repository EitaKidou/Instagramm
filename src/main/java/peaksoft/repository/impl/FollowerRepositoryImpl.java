package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.LobMergeStrategy;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Follower;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.repository.FollowerRepository;


import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class FollowerRepositoryImpl  implements FollowerRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<User> search(User userName, UserInfo fullName) {

        return null;
    }

    @Override
    public User subscribe(User profile) {
        User currentUser = getCurrentUser();
        if (currentUser.getFollower().getSubscriptions().contains(profile)) {
            currentUser.getFollower().getSubscriptions().remove(profile);
            profile.getFollower().getSubscribers().remove(currentUser);
        } else {
            currentUser.getFollower().getSubscriptions().add(profile);
            profile.getFollower().getSubscribers().add(currentUser);
        }
        entityManager.merge(currentUser);
        entityManager.merge(profile);

        return profile;
    }

    private User getCurrentUser() {
        return  null;
    }


    @Override
    public Follower getAllSubscribersByUserId(Long userId) {
        String queryString = "select f from Follower f join f.user u where u.id = :userId";
        TypedQuery<Follower> query = entityManager.createQuery(queryString, Follower.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    @Override
    public Follower getAllSubscriptionsByUserId(Long userId) {
        String queryString = "select f from Follower f join f.user u where u.id = :userId";
        Query<Follower> query = (Query<Follower>) entityManager.createQuery(queryString, Follower.class);
        query.setParameter("userId", userId);
        return (Follower) query.getResultList();
    }
}
