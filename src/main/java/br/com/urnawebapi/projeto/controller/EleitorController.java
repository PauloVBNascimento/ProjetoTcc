package br.com.urnawebapi.projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.urnawebapi.projeto.model.Eleitor;
import br.com.urnawebapi.projeto.service.EleitorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/eleitores")
public class EleitorController  {
    
    private EleitorService eleitorService;

    public EleitorController(EleitorService eleitorService) {  
        this.eleitorService = eleitorService;
    }

    @GetMapping
    public ResponseEntity<List<Eleitor>> listaEleitores () {
        return ResponseEntity.status(200).body(eleitorService.listarEleitor());
    }

    @PostMapping
    public ResponseEntity<Eleitor> criarEleitor (@RequestBody Eleitor eleitor) {
        return ResponseEntity.status(201).body(eleitorService.criarEleitor(eleitor));
    }

    @PutMapping
    public ResponseEntity<Eleitor> editarEleitor (@RequestBody Eleitor eleitor) {
        return ResponseEntity.status(200).body(eleitorService.editaEleitor(eleitor));
    }

    @DeleteMapping("/{id_e}")
    public ResponseEntity<?> excluirEleitor (@PathVariable Integer id_e) {
        eleitorService.excluirEleitor(id_e);
        return ResponseEntity.status(204).build();
    }

}
