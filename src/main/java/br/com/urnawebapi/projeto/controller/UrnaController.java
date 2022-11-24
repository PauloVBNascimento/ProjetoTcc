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

import br.com.urnawebapi.projeto.model.Urna;
import br.com.urnawebapi.projeto.service.SmsService;
import br.com.urnawebapi.projeto.service.UrnaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/urnas")
public class UrnaController {
   
    @Autowired
    private UrnaService urnaService;
    @Autowired
    private SmsService smsService;

    public UrnaController(UrnaService urnaService) {  
        this.urnaService = urnaService;
    }

    @GetMapping
    public Page<Urna> listaCandidatos ( Pageable pageable) {
        return urnaService.listarUrna(pageable);
    }

    @GetMapping("/{id}/notificar")
    public void notificar(@PathVariable Integer id){
        smsService.sendSms(id);
    }
    
    @GetMapping("/{id}")
    public Urna acharUrnaPeloId(@PathVariable Integer id){
        return urnaService.procurarUrna(id);
    }

    @PostMapping("/criar")
    public ResponseEntity<Urna> criarUrna (@Valid @RequestBody Urna urna) {
        return ResponseEntity.status(201).body(urnaService.criarUrna(urna));
        
    }

    @PutMapping("/{id}/editar")
    public ResponseEntity<Urna> editarUrna (@Valid @RequestBody Urna urna) {
        return ResponseEntity.status(200).body(urnaService.editaUrna(urna));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUrna (@PathVariable Integer id) {
        urnaService.excluirUrna(id);
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

