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

    @PostMapping("/{userId}")
    public ResponseEntity<Operation> create(@PathVariable Long userId, @RequestBody OperationDTO operationDTO, UriComponentsBuilder uriComponentsBuilder) {
        Operation newOperation = this.service.create(userId, operationDTO);

        var uri =  uriComponentsBuilder.path("/api/operation/{id}").buildAndExpand(newOperation.getId()).toUri();
        return ResponseEntity.created(uri).body(newOperation);
    }



    @GetMapping
    public ResponseEntity<OperationDTO> read(@RequestParam Long id) {
        OperationDTO operation = this.service.read(id);
        return ResponseEntity.ok(operation);
    }

    @PutMapping
    public ResponseEntity<OperationDTO> put(@RequestParam Long id, @RequestBody OperationDTO operationDTO) {
        this.service.put(id, operationDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
