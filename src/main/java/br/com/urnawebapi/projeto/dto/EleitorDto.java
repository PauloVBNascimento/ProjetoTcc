package br.com.urnawebapi.projeto.dto;

import javax.validation.Valid;

import br.com.urnawebapi.projeto.model.Eleitor;

public class EleitorDto {
    private String nome;
    private String email;
    private String senha;
    private String token;
    private String tipo;

    
    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getSenha() {
        return senha;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EleitorDto (){
        
    }

    public EleitorDto(String email, String nome, String token, String tipo) {
        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
    }



    public static EleitorDto toDTO(Eleitor user, String tipo) {
        return new EleitorDto(user.getEmail(), user.getNome(), user.getToken(), tipo);
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getTipo() {
        return tipo;
    }



    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public static EleitorDto toDTO(@Valid EleitorDto eleitor, String tipo) {
        return new EleitorDto(eleitor.getEmail(), eleitor.getNome(), eleitor.getToken(), tipo);
    }
}
