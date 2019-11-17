package pl.rynski.lab3_projektowanie_serwisow_www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;
import pl.rynski.lab3_projektowanie_serwisow_www.repository.BlogRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        blogRepository.save(new BlogPost("Tytul", "Opis", "Tag1, Tag2, Tag3"));
        blogRepository.save(new BlogPost("Tytul22", "Opis222", "Tag1111, Tag2222, Tag3333"));
        blogRepository.save(new BlogPost("Tytul3333", "Opis3333", "Tag123, Tag2345, Tag3234"));
    }

/*    public boolean addPost(BlogPost blogPost) {
        boolean add = postList.add(blogPost);
        if(add) {
            return true;
        } else {
            return false;
        }
    }*/

    public List<BlogPost> getPosts() {
        return blogRepository.findAll();
    }
}
