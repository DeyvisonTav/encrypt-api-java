package deyvisontav.com.encryptapi.services;

import deyvisontav.com.encryptapi.domain.operation.Operation;
import deyvisontav.com.encryptapi.dto.OperationDTO;
import deyvisontav.com.encryptapi.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OperationService {
   final private OperationRepository repository;
   final private EncryptService encryptService;

    public OperationService(OperationRepository repository, EncryptService encryptService) {
        this.repository = repository;
        this.encryptService = encryptService;
    }

    public Operation create(OperationDTO operationDTO) {
      Operation operation = new Operation();

      String userDocumentHashed = this.encryptService.encryptData(operationDTO.userDocument());
      String creditCardTokenHashed = this.encryptService.encryptData(operationDTO.creditCardToken());

      operation.setUserDocument(userDocumentHashed);
      operation.setCreditCardToken(creditCardTokenHashed);
      operation.setOperationValue(operationDTO.operationValue());

      this.repository.save(operation);
      return operation;
    }

    public OperationDTO read(Long id){
        Optional<Operation> operation = this.repository.findById(id);

        if(operation.isPresent()){
            String userDocument = this.encryptService.decryptData(operation.get().getUserDocument());
            String creditCardToken = this.encryptService.decryptData(operation.get().getCreditCardToken());

            return new OperationDTO(userDocument, creditCardToken, operation.get().getOperationValue());
        } else {
            throw new RuntimeException("Operation not found" + id);
        }

    }
}
