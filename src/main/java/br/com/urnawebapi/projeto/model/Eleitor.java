package br.com.urnawebapi.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "eleitor")
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e")
    private Integer id_e;

    @Column(name = "nome_e", length = 200, nullable = true)
    private String nome_e;

    @Column(name = "email_e", length = 50, nullable = true)
    private String email_e;

    @Column(name = "senha_e", columnDefinition = "TEXT", nullable = true)
    private String senha_e;

    @Column(name = "telefone_e", length = 15, nullable = true)
    private String telefone_e;

    public Integer getId_e() {
        return id_e;
    }
    public void setId_e(Integer id_e) {
        this.id_e = id_e;
    }
    public String getNome_e() {
        return nome_e;
    }
    public void setNome_e(String nome_e) {
        this.nome_e = nome_e;
    }
    public String getEmail_e() {
        return email_e;
    }
    public void setEmail_e(String email_e) {
        this.email_e = email_e;
    }
    public String getSenha_e() {
        return senha_e;
    }
    public void setSenha_e(String senha_e) {
        this.senha_e = senha_e;
    }
    public String getTelefone_e() {
        return telefone_e;
    }
    public void setTelefone_e(String telefone_e) {
        this.telefone_e = telefone_e;
    }

    
}
