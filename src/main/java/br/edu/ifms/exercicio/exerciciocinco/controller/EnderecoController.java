package br.edu.ifms.exercicio.exerciciocinco.controller;

import br.edu.ifms.exercicio.exerciciocinco.domain.dto.request.EnderecoRequest;
import br.edu.ifms.exercicio.exerciciocinco.domain.dto.response.EnderecoResponse;
import br.edu.ifms.exercicio.exerciciocinco.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/endereco")
    public ResponseEntity<EnderecoResponse> save(@RequestBody EnderecoRequest request){
        EnderecoResponse enderecoResponse = enderecoService.salvarEndereco(request);
        return ResponseEntity.ok(enderecoResponse);
    }
    @GetMapping("/endereco")
    public ResponseEntity<List<EnderecoResponse>> getAll(){
        List<EnderecoResponse> enderecoResponse = enderecoService.getAllEndereco();
        return ResponseEntity.ok(enderecoResponse);
    }
    @GetMapping("/endereco/{id}")
    public ResponseEntity<EnderecoResponse> getById(@PathVariable Integer id){
        EnderecoResponse enderecoResponse = enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(enderecoResponse);
    }
    @PutMapping("/endereco/{id}")
    public ResponseEntity<EnderecoResponse> update(@PathVariable Integer id, @RequestBody EnderecoRequest request){
        EnderecoResponse enderecoResponse = enderecoService.updateEndereco(id, request);
        return ResponseEntity.ok(enderecoResponse);
    }
    @DeleteMapping("/endereco/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        String message = enderecoService.deleteEndereco(id);
        return ResponseEntity.ok(message);
    }
}
