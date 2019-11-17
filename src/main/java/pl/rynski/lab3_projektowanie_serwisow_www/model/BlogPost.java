package pl.rynski.lab3_projektowanie_serwisow_www.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Blog_post")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(name = "time_post")
    private LocalDateTime timeOfPost;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryOfPost category;

    public BlogPost() {
    }

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = content;
        timeOfPost = LocalDateTime.now();
    }

    public BlogPost(String title, String content, CategoryOfPost category) {
        this.title = title;
        this.content = content;
        this.category = category;
        timeOfPost = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(LocalDateTime timeOfPost) {
        this.timeOfPost = timeOfPost;
    }

    public CategoryOfPost getCategory() {
        return category;
    }

    public void setCategory(CategoryOfPost category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timeOfPost=" + timeOfPost +
                '}';
    }
}
