package deyvisontav.com.encryptapi.domain.operation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operations")
public class Operation {

    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(nullable = false, name = "userdocument")
    private String userDocument;

    @Column(nullable = false, name = "creditcardtoken")
    private String creditCardToken;

    @Column(nullable = false, name = "operationvalue")
    private Long operationValue;

}

