package peaksoft.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "base_id",sequenceName = "user_seq",allocationSize = 1)
public class User extends BaseEntity {
    @Column(unique = true)
    private String user_name;
    private String password;
    @Column(unique = true)
    private String email;
    private String phone_number;


    @OneToMany(mappedBy = "user",cascade = {REMOVE,REFRESH})
    private List<Post> posts;

    @OneToOne(cascade = {REMOVE,REFRESH})
    private Like like;

    @ManyToMany(mappedBy = "users",cascade = {REMOVE,REFRESH})
    private List<Comment> comments;

    @ManyToOne(cascade = {REMOVE,REFRESH})
    private Image image;

    @OneToOne
    private Follower follower;

    @OneToOne(cascade = {REMOVE,REFRESH,PERSIST})
    private UserInfo userInfo;
}

