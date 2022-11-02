package com.myproject.RappeltacheBack.Repository;

import com.myproject.RappeltacheBack.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
        public Category findCategoryBycategoryName(String categoryName);
}

