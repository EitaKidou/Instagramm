package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "base_id",sequenceName = "comment_seq",allocationSize = 1)
public class Comment extends BaseEntity {

    private String comment;
    private LocalDate created_at;
    @ManyToOne()
    private Post post;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<Like> lists;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<User>users;


}
