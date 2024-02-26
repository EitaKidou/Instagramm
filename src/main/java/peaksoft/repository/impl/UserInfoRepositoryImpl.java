package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.UserInfo;
import peaksoft.repository.UserInfoRepository;


@Repository
@Transactional
@RequiredArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepository {
    @PersistenceContext
    private final   EntityManager entityManager;
    @Override
    public UserInfo findUserInfoByUserId(Long userId, Long userInfoId) {
       return  entityManager.createQuery("select userInfo from UserInfo userInfo where userInfo.user.id = :userID", UserInfo.class)
                .setParameter("userID", userId)
                .getSingleResult();
    }

    @Override
    public String updateUserInfoBYId(Long id, UserInfo newUserInfo) {
        try {
            UserInfo userInfo = entityManager.find(UserInfo.class, id);
            userInfo.setFull_name(newUserInfo.getFull_name());
            userInfo.setBiography(newUserInfo.getBiography());
            userInfo.setGender(newUserInfo.getGender());
            userInfo.setImage(newUserInfo.getImage());
            entityManager.merge(userInfo);
            return "updated successfully";
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return "failed";
    }
    @Override
    public String changeImageByUserInfoId(Long userInfoId, UserInfo newUserInfo) {
        try {
            UserInfo userInfo = entityManager.find(UserInfo.class, userInfoId);
            userInfo.setImage(newUserInfo.getImage());
            entityManager.merge(userInfo);
            return "updated successfully";
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return "failed";
    }

    @Override
    public String deleteImageByUserInfoId(Long Id) {
        try {
            UserInfo userInfo = entityManager.find(UserInfo.class, Id);
            entityManager.remove(userInfo.getImage());
            return "updated successfully";
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        }
        return "failed";
    }

}