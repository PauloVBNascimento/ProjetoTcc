package br.com.urnawebapi.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.urnawebapi.projeto.model.Urna;

//public interface EleitorInterface extends JpaRepository<Eleitor, Integer>{

public interface UrnaInterface extends JpaRepository<Urna, Integer> {
    
    @Query("SELECT obj FROM Urna obj ORDER BY obj.id ASC")
    Page<Urna> findUrnas(Pageable pageable);
}
