package br.com.urnawebapi.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.urnawebapi.projeto.model.CandidatoUrna;

public interface CandidatoUrnaInterface extends JpaRepository<CandidatoUrna, Integer>{

    //Candidato findByEmail(String email);

    @Query("SELECT obj FROM CandidatoUrna obj ORDER BY obj.id ASC")
    Page<CandidatoUrna> findCandidatoUrnas(Pageable pageable);  
    
    
} 