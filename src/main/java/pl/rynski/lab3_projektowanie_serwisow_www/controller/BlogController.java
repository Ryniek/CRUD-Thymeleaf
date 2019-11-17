package pl.rynski.lab3_projektowanie_serwisow_www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;
import pl.rynski.lab3_projektowanie_serwisow_www.service.BlogService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("postsList", blogService.getPosts());
        return "index";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String title,
                          @RequestParam String content,
                          @RequestParam String tags) {
        BlogPost blogPost = new BlogPost(title, content, tags);
        blogPost.setTimeOfPost(LocalDateTime.now());
        System.out.println(blogPost);
        return "redirect:/";
    }
}