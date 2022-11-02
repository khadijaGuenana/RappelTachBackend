package com.myproject.RappeltacheBack.Service;

import com.myproject.RappeltacheBack.Entity.Category;

import java.util.List;

public interface CategoryService  {
    public Category addCategory(Category category);
    public List<Category> getAll();
    public void deleteCategory(long idCategory);
    public Category findCategoryById(long idCategory);
    public Category findCategoryByCategoryName(String CategoryName);

}
