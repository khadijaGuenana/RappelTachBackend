package com.myproject.RappeltacheBack.Service;

import com.myproject.RappeltacheBack.Entity.Category;
import com.myproject.RappeltacheBack.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {

        return  categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(long idCategory) {
        categoryRepository.deleteById(idCategory);

    }

    @Override
    public Category findCategoryById(long idCategory) {

        return categoryRepository.findById(idCategory).get();
    }

    @Override
    public Category findCategoryByCategoryName(String CategoryName ) {
        return categoryRepository.findCategoryBycategoryName(CategoryName);
    }
}
