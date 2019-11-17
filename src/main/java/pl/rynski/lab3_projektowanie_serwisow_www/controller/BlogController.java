package pl.rynski.lab3_projektowanie_serwisow_www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;
import pl.rynski.lab3_projektowanie_serwisow_www.model.CategoryOfPost;
import pl.rynski.lab3_projektowanie_serwisow_www.service.CategoryService;
import pl.rynski.lab3_projektowanie_serwisow_www.service.PostService;

@Controller
@RequestMapping("/")
public class BlogController {

    private PostService postService;
    private CategoryService categoryService;

    @Autowired
    public BlogController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("postsList", postService.getPosts());
        model.addAttribute("categories", categoryService.getCategories());
        return "index";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String title,
                          @RequestParam String content,
                          @RequestParam String categoryy) {
        System.out.println(categoryy);
        postService.addPost(new BlogPost(title, content));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.removePost(id+1);
        return "redirect:/";
    }
}
