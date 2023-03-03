package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    @Query("select (count(p) > 0) from ProductEntity p where p.product_id = ?1")
    boolean existsByProduct_id(@NonNull Long product_id);
}