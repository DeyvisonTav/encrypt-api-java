package deyvisontav.com.encryptapi.controllers;

import deyvisontav.com.encryptapi.domain.operation.Operation;
import deyvisontav.com.encryptapi.dto.OperationDTO;
import deyvisontav.com.encryptapi.services.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/operation")
public class OperationController {

 final private OperationService service;

    public OperationController(OperationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Operation> create(@RequestBody OperationDTO operationDTO, UriComponentsBuilder uriComponentsBuilder) {
        Operation newOperation = this.service.create(operationDTO);

        var uri =  uriComponentsBuilder.path("/api/operation/{id}").buildAndExpand(newOperation.getId()).toUri();
        return ResponseEntity.created(uri).body(newOperation);
    }

    @GetMapping
    public ResponseEntity<OperationDTO> read(@RequestParam Long id) {
        OperationDTO operation = this.service.read(id);
        return ResponseEntity.ok(operation);
    }
}