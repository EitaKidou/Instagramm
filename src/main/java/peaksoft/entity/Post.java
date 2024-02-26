package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "base_id",sequenceName = "post_seq",allocationSize = 1)
public class Post extends BaseEntity {
    private String title;
    private String description;
    private LocalDate created_at;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post",cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
    private List<Like>likes;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Image> images;



}