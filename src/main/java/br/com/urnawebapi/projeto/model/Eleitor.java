package br.com.urnawebapi.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "eleitor")
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e")
    private Integer id_e;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min=3, message = "O nome deve ter no mínimo 3 caracteres!")
    @Column(name = "nome_e", length = 200, nullable = false)
    private String nome_e;

    @Email(message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email_e", length = 50, nullable = false)
    private String email_e;

    @NotBlank(message = "A senha é obrigatória!")
    @Size(min=6, message = "A senha deve ter no mínimo 6 caracteres!")
    @Column(name = "senha_e", columnDefinition = "TEXT", nullable = false)
    private String senha_e;

    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone_e", length = 15, nullable = false)
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
