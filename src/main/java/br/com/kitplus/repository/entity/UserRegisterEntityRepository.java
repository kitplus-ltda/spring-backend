package br.com.kitplus.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface UserRegisterEntityRepository extends JpaRepository<UserRegisterEntity, Long> {
    @Transactional
    @Modifying
    @Query("update UserRegisterEntity u set u.idPaymentIntegration = ?1 where u.documentNumber = ?2")
    int updateIdPaymentIntegrationByDocumentNumber(@NonNull String idPaymentIntegration, @NonNull String documentNumber);
    boolean existsByEmail(@NonNull String email);
    boolean existsByDocumentNumber(@NonNull String documentNumber);
    UserRegisterEntity findByEmail(String email);
    UserRegisterEntity findByDocumentNumberLike(@NonNull String documentNumber);
}