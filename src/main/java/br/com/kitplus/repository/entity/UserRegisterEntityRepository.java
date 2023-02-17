package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface UserRegisterEntityRepository extends JpaRepository<UserRegisterEntity, Long> {
    boolean existsByEmail(@NonNull String email);
    boolean existsByDocumentNumber(@NonNull String documentNumber);
    UserRegisterEntity findByEmail(String email);
    UserRegisterEntity findByDocumentNumberLike(@NonNull String documentNumber);
}