package peaksoft.service;


import peaksoft.entity.UserInfo;

public interface UserInfoService {
    UserInfo findUserInfoByUserId(Long userId, Long userInfoId);
    String updateUserInfoBYId(Long id , UserInfo newUserInfo);

    String changeImageByUserInfoId(Long userInfoId, UserInfo newUserInfo);
    String deleteImageByUserInfoId(Long Id);
}
