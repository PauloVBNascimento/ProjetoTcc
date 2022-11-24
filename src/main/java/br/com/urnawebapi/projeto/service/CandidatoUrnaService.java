package br.com.urnawebapi.projeto.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import br.com.urnawebapi.projeto.model.CandidatoUrna;
import br.com.urnawebapi.projeto.repository.CandidatoUrnaInterface;


@Service
public class CandidatoUrnaService {
    private CandidatoUrnaInterface repository;

    public CandidatoUrnaService(CandidatoUrnaInterface repository) {
        this.repository = repository;
    }

    public Page<CandidatoUrna> listarCandidatoUrna(Pageable pageable) {
        return repository.findCandidatoUrnas(pageable);
    }

    public CandidatoUrna criarCandidatoUrna(CandidatoUrna candidatourna) {
        CandidatoUrna candidatournanovo = repository.save(candidatourna);
        return candidatournanovo;
    }

    public CandidatoUrna procurarCandidatoUrna(Integer id) {
        Optional<CandidatoUrna> candidatournaencontrado = repository.findById(id);
        if (candidatournaencontrado.isPresent()) {
            return candidatournaencontrado.get();
        }
        throw new RuntimeException("Não encontrei");
    }

    public CandidatoUrna editaCandidatoUrna(CandidatoUrna candidatourna) {
        CandidatoUrna candidatournanovo = repository.save(candidatourna);
        return candidatournanovo;
    }

    public Boolean excluirCandidatoUrna(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
