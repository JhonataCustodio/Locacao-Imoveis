package br.edu.ifms.exercicio.exerciciocinco.controller;

import br.edu.ifms.exercicio.exerciciocinco.domain.dto.request.LocatarioRequest;
import br.edu.ifms.exercicio.exerciciocinco.domain.dto.response.LocatarioResponse;
import br.edu.ifms.exercicio.exerciciocinco.domain.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocatarioController {
    @Autowired
    private LocatarioService locatarioService;
    @PostMapping("/locatario")
    public ResponseEntity<LocatarioResponse> save(@RequestBody LocatarioRequest request){
        LocatarioResponse locatarioResponse = locatarioService.salvarLocatario(request);
        return ResponseEntity.ok(locatarioResponse);
    }
    @GetMapping("/locatario")
    public ResponseEntity<List<LocatarioResponse>> getAll(){
        List<LocatarioResponse> locatarioResponse = locatarioService.getAllLocatario();
        return ResponseEntity.ok(locatarioResponse);
    }
    @GetMapping("/locatario/{id}")
    public ResponseEntity<LocatarioResponse> getById(@PathVariable Integer id){
        LocatarioResponse locatarioResponse = locatarioService.getLocatarioById(id);
        return ResponseEntity.ok(locatarioResponse);
    }
    @PutMapping("/locatario/{id}")
    public ResponseEntity<LocatarioResponse> update(@PathVariable Integer id, @RequestBody LocatarioRequest request){
        LocatarioResponse locatarioResponse = locatarioService.updateLocatario(id, request);
        return ResponseEntity.ok(locatarioResponse);
    }
    @DeleteMapping("/locatario/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        String message = locatarioService.deleteLocatario(id);
        return ResponseEntity.ok(message);
    }
}
