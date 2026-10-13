package org.example.session04.controllers;

import lombok.RequiredArgsConstructor;
import org.example.session04.models.entities.Category;
import org.example.session04.models.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<?> addNewCategory(@RequestBody Category category) {
        return ResponseEntity.status(201).body(categoryService.addNewCategory(category));
    }

}
