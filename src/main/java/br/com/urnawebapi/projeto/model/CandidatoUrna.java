package br.com.urnawebapi.projeto.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "candidatourna")
public class CandidatoUrna {
    
    @EmbeddedId
    CandidatoUrnaChave id;

    @ManyToOne
    @MapsId("idc")
    @JoinColumn(name="idc")
    Candidato candidato;

    @ManyToOne
    @MapsId("idu")
    @JoinColumn(name="idu")
    Urna urna;

    @Column(name = "votos", nullable = false)
    private Integer votos;

    public CandidatoUrnaChave getId() {
        return id;
    }

    public void setId(CandidatoUrnaChave id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Urna getUrna() {
        return urna;
    }

    public void setUrna(Urna urna) {
        this.urna = urna;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public CandidatoUrna(CandidatoUrnaChave id, Candidato candidato, Urna urna, Integer votos) {
        this.id = id;
        this.candidato = candidato;
        this.urna = urna;
        this.votos = votos;
    }

    public CandidatoUrna() {
        
    }
}
