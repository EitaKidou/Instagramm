package peaksoft.repository;


import peaksoft.entity.UserInfo;

public interface UserInfoRepository {
    UserInfo findUserInfoByUserId(Long userId, Long userInfoId);
    String updateUserInfoBYId(Long id , UserInfo newUserInfo);

    String changeImageByUserInfoId(Long userInfoId, UserInfo newUserInfo);
    String deleteImageByUserInfoId(Long Id);

}