package br.com.urnawebapi.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.urnawebapi.projeto.model.Eleitor;
import br.com.urnawebapi.projeto.repository.EleitorInterface;

@Service
public class EleitorService {
    
    private EleitorInterface repository;

    public EleitorService(EleitorInterface repository) {
        this.repository = repository;
    }

    public List<Eleitor> listarEleitor() {
        List<Eleitor> lista = repository.findAll();
        return lista;
    }

    public Eleitor criarEleitor(Eleitor eleitor) {
        Eleitor eleitorNovo = repository.save(eleitor);
        return eleitorNovo;
    }

    public Eleitor editaEleitor(Eleitor eleitor) {
        Eleitor eleitorNovo = repository.save(eleitor);
        return eleitorNovo;
    }

    public Boolean excluirEleitor(Integer id_e) {
        repository.deleteById(id_e);
        return true;
    }
}
