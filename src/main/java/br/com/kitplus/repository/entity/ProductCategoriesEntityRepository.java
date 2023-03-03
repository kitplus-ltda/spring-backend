package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface ProductCategoriesEntityRepository extends JpaRepository<ProductCategoriesEntity, Long> {
    @Query("select (count(p) > 0) from ProductCategoriesEntity p where p.category_id = ?1")
    boolean existsByCategory_id(@NonNull Long category_id);
}