package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface UserSignInEntityRepository extends JpaRepository<UserSignInEntity, Long> {
    boolean existsByUser(@NonNull String user);
    boolean existsByEmail(@NonNull String email);
}