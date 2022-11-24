package br.com.urnawebapi.projeto.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "urna")
public class Urna {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idc", nullable = false)
    Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "ide", nullable = false)
    Eleitor eleitor;

    @Column(name = "nome", nullable = false, unique=true)
    private String nome;

    @Column(name = "datainicial", nullable = false)
    private LocalDate datainicial;

    @Column(name = "datafinal", nullable = false)
    private LocalDate datafinal;

    @OneToMany (mappedBy = "urna")
    Set<CandidatoUrna> votostotais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatainicial() {
        return datainicial;
    }

    public void setDatainicial(LocalDate datainicial) {
        this.datainicial = datainicial;
    }

    public LocalDate getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(LocalDate datafinal) {
        this.datafinal = datafinal;
    }

    public Urna(Integer id, Candidato candidato, Eleitor eleitor, String nome, LocalDate datainicial,
            LocalDate datafinal) {
        this.id = id;
        this.candidato = candidato;
        this.eleitor = eleitor;
        this.nome = nome;
        this.datainicial = datainicial;
        this.datafinal = datafinal;
    }

    public Urna() {

    }

    
}
