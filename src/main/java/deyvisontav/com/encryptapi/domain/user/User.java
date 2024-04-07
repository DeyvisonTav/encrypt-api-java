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

    @Column(nullable = false, name = "operation_ids")
    private
    Integer[] operationIds;

    public Integer[] getOperationIds() {
        return operationIds;
    }

    public void setOperationIds(Integer[] operationIds) {
        this.operationIds = operationIds;
    }

    public void addOperationId(int id) {
        if (this.operationIds == null) {
            this.operationIds = new Integer[]{id};
        } else {
            Integer[] newOperationIds = new Integer[this.operationIds.length + 1];

            System.arraycopy(this.operationIds, 0, newOperationIds, 0, this.operationIds.length);

            newOperationIds[this.operationIds.length] = id;

            this.operationIds = newOperationIds;
        }
    }

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
