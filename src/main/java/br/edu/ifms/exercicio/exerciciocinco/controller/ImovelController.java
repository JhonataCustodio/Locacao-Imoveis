package br.edu.ifms.exercicio.exerciciocinco.controller;

import br.edu.ifms.exercicio.exerciciocinco.domain.dto.request.ImovelRequest;
import br.edu.ifms.exercicio.exerciciocinco.domain.dto.response.ImovelResponse;
import br.edu.ifms.exercicio.exerciciocinco.domain.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping("/imovel")
    public ResponseEntity<ImovelResponse> save(@RequestBody ImovelRequest request){
        ImovelResponse imovelResponse = imovelService.salvarImovel(request);
        return ResponseEntity.ok(imovelResponse);
    }
    @GetMapping("/imovel")
    public ResponseEntity<List<ImovelResponse>> getAll(){
        List<ImovelResponse> imovelResponse = imovelService.getAllImovel();
        return ResponseEntity.ok(imovelResponse);
    }
    @GetMapping("/imovel/{id}")
    public ResponseEntity<ImovelResponse> getById(@PathVariable Integer id){
        ImovelResponse imovelResponse = imovelService.getImovelById(id);
        return ResponseEntity.ok(imovelResponse);
    }
    @PutMapping("/imovel/{id}")
    public ResponseEntity<ImovelResponse> update(@PathVariable Integer id, @RequestBody ImovelRequest request){
        ImovelResponse imovelResponse = imovelService.updateImovel(id, request);
        return ResponseEntity.ok(imovelResponse);
    }
    @DeleteMapping("/imovel/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        String message = imovelService.deleteImovel(id);
        return ResponseEntity.ok(message);
    }
}
