package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userinfos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "base_id",sequenceName = "userinfo_seq",allocationSize = 1)
public class UserInfo  extends BaseEntity {


    private String full_name;
    private String biography;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;

    @OneToOne
    private User user;

}