package deyvisontav.com.encryptapi.services;

import deyvisontav.com.encryptapi.domain.operation.Operation;
import deyvisontav.com.encryptapi.domain.user.User;
import deyvisontav.com.encryptapi.dto.OperationDTO;
import deyvisontav.com.encryptapi.repositories.OperationRepository;
import deyvisontav.com.encryptapi.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class OperationService {

    final private UserRepository user;
   final private OperationRepository repository;
   final private EncryptService encryptService;

    public OperationService(OperationRepository repository, EncryptService encryptService, UserRepository user) {
        this.repository = repository;
        this.encryptService = encryptService;
        this.user = user;
    }

    public Operation create(Long userId, OperationDTO operationDTO) {
        if (userId == null || operationDTO == null) {
            throw new IllegalArgumentException("UserId and operationDTO cannot be null.");
        }

        User userExists =  this.user.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        String encryptedUserDocument = this.encryptService.encryptData(operationDTO.userDocument());
        String encryptedCreditCardToken = this.encryptService.encryptData(operationDTO.creditCardToken());

        Operation operation = new Operation();
        operation.setUserDocument(encryptedUserDocument);
        operation.setCreditCardToken(encryptedCreditCardToken);
        operation.setOperationValue(operationDTO.operationValue());
        operation.setUserId(userId);

        Operation savedOperation = this.repository.save(operation);

        Long operationId = savedOperation.getId();

        userExists.addOperationId(operationId.intValue());

        this.user.save(userExists);

        return savedOperation;
    }



    public OperationDTO read(Long id){
        Optional<Operation> operation = this.repository.findById(id);

        if(operation.isPresent()){
            String userDocument = this.encryptService.decryptData(operation.get().getUserDocument());
            String creditCardToken = this.encryptService.decryptData(operation.get().getCreditCardToken());

            return new OperationDTO(userDocument, creditCardToken, operation.get().getOperationValue(), operation.get().getUser().getId());
        } else {
            throw new RuntimeException("Operation not found " + id);
        }

    }

    public void put(Long id, OperationDTO operationDTO) {

        Operation  operation = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Operation not found " + id));

        if(operationDTO.userDocument() != null){
            String userDocumentHashed = this.encryptService.encryptData(operationDTO.userDocument());
            operation.setUserDocument(userDocumentHashed);
        }

        if(operationDTO.creditCardToken() != null){
            String creditCardTokenHashed = this.encryptService.encryptData(operationDTO.creditCardToken());
            operation.setCreditCardToken(creditCardTokenHashed);
        }

        if(operationDTO.operationValue() != null){
            operation.setOperationValue(operationDTO.operationValue());
        }

        this.repository.save(operation);
    }

    public void delete(Long id) {
       Operation operation = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Operation not found " + id));
       this.repository.delete(operation);
    }

}
