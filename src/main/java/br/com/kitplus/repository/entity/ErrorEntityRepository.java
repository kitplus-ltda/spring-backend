package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface ErrorEntityRepository extends JpaRepository<ErrorEntity, Long> {
    ErrorEntity findByErro(@NonNull String erro);
}