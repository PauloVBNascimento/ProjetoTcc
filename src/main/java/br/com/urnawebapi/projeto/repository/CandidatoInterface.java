package br.com.urnawebapi.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.urnawebapi.projeto.model.Candidato;

public interface CandidatoInterface extends JpaRepository<Candidato, Integer>{

    //Candidato findByEmail(String email);

    @Query("SELECT obj FROM Candidato obj ORDER BY obj.id ASC")
    Page<Candidato> findCandidatos(Pageable pageable);  
    
    
}
