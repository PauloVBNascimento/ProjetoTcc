package br.com.urnawebapi.projeto.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.urnawebapi.projeto.model.CandidatoUrna;
import br.com.urnawebapi.projeto.service.CandidatoUrnaService;
import br.com.urnawebapi.projeto.service.SmsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/candidatournas")

public class CandidatoUrnaController {
    @Autowired
    private CandidatoUrnaService candidatoUrnaService;
    @Autowired
    private SmsService smsService;

    public CandidatoUrnaController(CandidatoUrnaService candidatoUrnaService) {  
        this.candidatoUrnaService = candidatoUrnaService;
    }

    @GetMapping
    public Page<CandidatoUrna> listaCandidatoUrnas ( Pageable pageable) {
        return candidatoUrnaService.listarCandidatoUrna(pageable);
    }

    @GetMapping("/{id}/notificar")
    public void notificar(@PathVariable Integer id){
        smsService.sendSms(id);
    }
    
    @GetMapping("/{id}")
    public CandidatoUrna acharCandidatoUrnaPeloId(@PathVariable Integer id){
        return candidatoUrnaService.procurarCandidatoUrna(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<CandidatoUrna> criarCandidatoUrna (@Valid @RequestBody CandidatoUrna candidatourna) {
        return ResponseEntity.status(201).body(candidatoUrnaService.criarCandidatoUrna(candidatourna));
        
    }

    @PutMapping("/{id}/editar")
    public ResponseEntity<CandidatoUrna> editarCandidatoUrna (@Valid @RequestBody CandidatoUrna candidatourna) {
        return ResponseEntity.status(200).body(candidatoUrnaService.editaCandidatoUrna(candidatourna));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCandidatoUrna (@PathVariable Integer id) {
        candidatoUrnaService.excluirCandidatoUrna(id);
        return ResponseEntity.status(204).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeCampo = ((FieldError) error).getField();
            String mensagemErro = error.getDefaultMessage();
            erros.put(nomeCampo, mensagemErro);
            
        });

        return erros;
    }
}
