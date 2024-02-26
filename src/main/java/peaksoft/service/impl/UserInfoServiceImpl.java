package peaksoft.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.UserInfo;
import peaksoft.repository.UserInfoRepository;
import peaksoft.service.UserInfoService;


@Service
@Transactional
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findUserInfoByUserId(Long userId, Long userInfoId) {
        return userInfoRepository.findUserInfoByUserId(userId,userInfoId);
    }

    @Override
    public String updateUserInfoBYId(Long id, UserInfo newUserInfo) {
        return userInfoRepository.updateUserInfoBYId(id,newUserInfo);
    }

    @Override
    public String changeImageByUserInfoId(Long userInfoId, UserInfo newUserInfo) {
        return userInfoRepository.changeImageByUserInfoId(userInfoId,newUserInfo);
    }

    @Override
    public String deleteImageByUserInfoId(Long Id) {
        return userInfoRepository.deleteImageByUserInfoId(Id);
    }
}