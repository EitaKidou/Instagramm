package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "base_id",sequenceName = "follower_seq",allocationSize = 1)
public class Follower extends BaseEntity {

    @ManyToMany
    @JoinTable(name = "follower_subscribers",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    private List<User> subscribers ;

    @ManyToMany
    @JoinTable(name = "follower_subscriptions",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<User> subscriptions ;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;


}