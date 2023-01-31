 package br.com.kitplus.repository.entity;


 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;

 import javax.persistence.*;
 import javax.validation.constraints.Size;

 @NoArgsConstructor
 @Getter
 @Setter
 @Entity
 @Table(name = "user_sign_in")
 public class UserSignInEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @Column(name = "id", nullable = false)
     private Long id;

     @Column(name = "password")
     @Size(max = 255)
     public String password;

     @Column(name = "users", unique = true)
     @Size(max = 255)
     public String user;

     @Column(name = "email", unique = true)
     @Size(max = 255)
     public String email;

     @OneToOne
     private UserRegisterEntity userRegisterEntity;


 }


