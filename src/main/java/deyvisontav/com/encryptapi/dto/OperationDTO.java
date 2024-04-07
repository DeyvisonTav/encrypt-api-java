package deyvisontav.com.encryptapi.dto;

public record OperationDTO(String userDocument, String creditCardToken, Long operationValue, Long userId) {
}