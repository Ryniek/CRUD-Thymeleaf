package pl.rynski.lab3_projektowanie_serwisow_www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.rynski.lab3_projektowanie_serwisow_www.model.BlogPost;
import pl.rynski.lab3_projektowanie_serwisow_www.model.CategoryOfPost;
import pl.rynski.lab3_projektowanie_serwisow_www.service.CategoryService;
import pl.rynski.lab3_projektowanie_serwisow_www.service.PostService;

import java.time.LocalDateTime;

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
                          @RequestParam String category) {
        postService.addPost(new BlogPost(title, content, categoryService.getCategoryByName(category)));
        return "redirect:/";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam String name) {
        categoryService.addCategory(new CategoryOfPost(name));
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("postToUpdate", postService.getPost(id));
        model.addAttribute("categories", categoryService.getCategories());
        return "update";
    }

    @PostMapping("/updatePost/{id}")
    public String updatePost(@RequestParam(required = false) String title,
                             @RequestParam(required = false) String content,
                             @RequestParam(required = false) String category,
                             @PathVariable Long id) {
        BlogPost update = new BlogPost(title, content, categoryService.getCategoryByName(category));
        postService.updatePost(id, update);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.removePost(id);
        return "redirect:/";
    }
}
