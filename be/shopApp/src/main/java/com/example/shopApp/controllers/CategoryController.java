package com.example.shopApp.controllers;

import com.example.shopApp.dtos.CategoryDTO;
import com.example.shopApp.models.Category;
import com.example.shopApp.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
//@Validated
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorsMessage = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errorsMessage);
        }
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("Insert Category Successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCategoriesById(
            @PathVariable Long id
    ) {
        categoryService.getCategoryById(id);
        return ResponseEntity.ok("Get category with id = " + id + " successfully" );
    }
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(
//            @RequestParam("page") int page,
//            @RequestParam("limit") int limit
    ) {
        List<Category> categories =  categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable long id,@RequestBody @Valid CategoryDTO categoryDTO) {
//        CategoryService.
        categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok("update category successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete category with id = " + id + " successfully");
    }
}
