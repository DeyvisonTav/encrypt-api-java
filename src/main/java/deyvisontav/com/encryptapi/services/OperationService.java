package deyvisontav.com.encryptapi.services;

import deyvisontav.com.encryptapi.domain.operation.Operation;
import deyvisontav.com.encryptapi.dto.OperationDTO;
import deyvisontav.com.encryptapi.repositories.OperationRepository;

public class OperationService {
    private OperationRepository repository;
    private EncryptService encryptService;

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
}
