package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "base_id", sequenceName = "image_seq", allocationSize = 1)
public class Image extends BaseEntity {

    private String image_url;

    @ManyToOne
    private Post post;

    @OneToMany(mappedBy = "image")
    private List<User> users;

}
