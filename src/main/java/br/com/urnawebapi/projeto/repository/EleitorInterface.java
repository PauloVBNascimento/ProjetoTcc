package br.com.urnawebapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.urnawebapi.projeto.model.Eleitor;

public interface EleitorInterface extends JpaRepository<Eleitor, Integer>{
    
}
