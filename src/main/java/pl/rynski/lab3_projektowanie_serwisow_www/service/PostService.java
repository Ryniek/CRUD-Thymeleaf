package pl.rynski.lab3_projektowanie_serwisow_www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;
import pl.rynski.lab3_projektowanie_serwisow_www.repository.BlogRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private BlogRepository blogRepository;

    @Autowired
    public PostService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        blogRepository.save(new BlogPost("Tytul", "Opis"));
        blogRepository.save(new BlogPost("Tytul22", "Opis222"));
        blogRepository.save(new BlogPost("Tytul3333", "Opis3333"));
    }

    public List<BlogPost> getPosts() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "timeOfPost"));
    }

    public BlogPost getPost(Long id) {
        return blogRepository.findById(id).get();
    }

    public boolean addPost(BlogPost blogPost) {
        BlogPost add = blogRepository.save(blogPost);
        if(add != null) {
            return true;
        } else {
            return false;
        }
    }

    public void updatePost(Long id, BlogPost update) {
        BlogPost blogPost = blogRepository.findById(id).get();
        if(!update.getTitle().isEmpty())
            blogPost.setTitle(update.getTitle());
        if(!update.getContent().isEmpty())
            blogPost.setContent(update.getContent());
        if(update.getCategory() != null) {
            blogPost.setCategory(update.getCategory());
        }
        //blogPost.setTimeOfPost(LocalDateTime.now());
        addPost(blogPost);
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
