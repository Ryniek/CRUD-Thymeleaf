package pl.rynski.lab3_projektowanie_serwisow_www.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_of_post")
public class CategoryOfPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<BlogPost> posts;

    public CategoryOfPost() {
    }

    public CategoryOfPost(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
