package br.com.urnawebapi.projeto.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.urnawebapi.projeto.model.Urna;
import br.com.urnawebapi.projeto.repository.UrnaInterface;

@Service
public class UrnaService {
    private UrnaInterface repository;

    public UrnaService(UrnaInterface repository) {
        this.repository = repository;
    }

    public Page<Urna> listarUrna(Pageable pageable) {
        return repository.findUrnas(pageable);
    }

    public Urna criarUrna(Urna urna) {
        Urna urnanova = repository.save(urna);
        return urnanova;
    }

    public Urna procurarUrna(Integer id) {
        Optional<Urna> urnaencontrada = repository.findById(id);
        if (urnaencontrada.isPresent()) {
            return urnaencontrada.get();
        }
        throw new RuntimeException("Não encontrei");
    }

    public Urna editaUrna(Urna urna) {
        Urna urnanova = repository.save(urna);
        return urnanova;
    }

    public Boolean excluirUrna(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
