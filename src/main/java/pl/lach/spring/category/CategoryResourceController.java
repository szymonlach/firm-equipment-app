package pl.lach.spring.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryResourceController {

    private CategoryService categoryService;

    @Autowired
    public CategoryResourceController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/names")
    public List<String> findAll() {
        return categoryService.findAllNames();
    }
}
