package deyvisontav.com.encryptapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Column(nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

   public Long getId() {
       return id;
   }

   public String getName() {
       return name;
   }

   public String getEmail() {
       return email;
   }

   public String getPassword() {
       return password;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public void setPassword(String password) {
       this.password = password;
   }

}
