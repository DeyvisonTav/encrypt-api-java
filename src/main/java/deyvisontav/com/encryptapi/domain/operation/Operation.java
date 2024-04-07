package deyvisontav.com.encryptapi.domain.operation;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(name = "userdocument")
     private String userDocument;

    @Column(name = "creditcardtoken")
    private String creditCardToken;
    @Column(name = "operationvalue")
    private Long operationValue;


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


