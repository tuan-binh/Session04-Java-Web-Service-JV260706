package org.example.session04.models.services;

import lombok.RequiredArgsConstructor;
import org.example.session04.models.entities.Category;
import org.example.session04.models.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {

        /*
            findAll() - Lấy dánh sách tất cả đối tượng
            save() - thêm mới (không có id trong đối tượng cần lưu) và cập nhật (bắt buộc phải có id trong đối tượng cần lưu)
            deleteById(Long id)
        */

        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Xây dựng 1 chương trình quản lý về động vật (sở thú zoo) (Có lưu trữ Database)
    /*
        Động vật sẽ có các thuộc tính sau:
            - id
            - name
            - breed
            - age
            - weight
        Xây dựng các API sai:
            - Lấy danh sách các động vật
            - Lấy thông tin chi tiết 1 động vật theo id
            - Thêm mới 1 động vật
            - Cập nhật thông tin 1 động vật theo id
            - Xóa 1 động vật theo id
    */

}
