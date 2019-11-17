package pl.rynski.lab3_projektowanie_serwisow_www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;
import pl.rynski.lab3_projektowanie_serwisow_www.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

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

    public List<BlogPost> getPosts() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "timeOfPost"));
    }

    public boolean addPost(BlogPost blogPost) {
        BlogPost add = blogRepository.save(blogPost);
        if(add != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removePost(Long id) {
        Optional<BlogPost> blogPost = blogRepository.findById(id);
        if(blogPost.isPresent()) {
            blogRepository.delete(blogPost.get());
            return true;
        } else {
            return false;
        }
    }
}
