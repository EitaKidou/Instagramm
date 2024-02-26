package peaksoft.service;



import peaksoft.entity.Follower;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;

import java.util.List;

public interface FollowerService {
    List<User> search(User userName, UserInfo fullName);

    User subscribe (User profile);
    Follower getAllSubscribersByUserId(Long userId);
    Follower getAllSubscriptionsByUserId(Long userId);
}
