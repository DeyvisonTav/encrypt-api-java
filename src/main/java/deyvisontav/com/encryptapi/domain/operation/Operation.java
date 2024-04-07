package deyvisontav.com.encryptapi.domain.operation;

import deyvisontav.com.encryptapi.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operations")
public class Operation {

    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    private User userId;

    @Column(name = "userdocument",nullable = false)
     private String userDocument;

    @Column(name = "creditcardtoken", nullable = false)
    private String creditCardToken;
    @Column(name = "operationvalue", nullable = false)
    private Long operationValue;


    public void setUserId(Long userId) {
        User user = new User();
        user.setId(userId);
        this.userId = user;
    }

    public User getUser() {
        return userId;
    }
    public Long getId() {
        return id;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    public Long getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(Long operationValue) {
        this.operationValue = operationValue;
    }




}


