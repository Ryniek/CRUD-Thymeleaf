package pl.rynski.lab3_projektowanie_serwisow_www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.lab3_projektowanie_serwisow_www.model.CategoryOfPost;
import pl.rynski.lab3_projektowanie_serwisow_www.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        categoryRepository.save(new CategoryOfPost("Sport"));
        categoryRepository.save(new CategoryOfPost("Technology"));
        categoryRepository.save(new CategoryOfPost("Art"));
    }

    public List<CategoryOfPost> getCategories() {
        return categoryRepository.findAll();
    }

    public CategoryOfPost getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public boolean addCategory(CategoryOfPost category) {
        CategoryOfPost add = categoryRepository.save(category);
        if(add != null) {
            return true;
        } else {
            return false;
        }
    }


}
