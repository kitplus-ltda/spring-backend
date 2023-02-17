package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface UserRegisterEntityRepository extends JpaRepository<UserRegisterEntity, Long> {
    UserRegisterEntity findByEmail(String email);
    UserRegisterEntity findByDocumentNumberLike(@NonNull String documentNumber);
}