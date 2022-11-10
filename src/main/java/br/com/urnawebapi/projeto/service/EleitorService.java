package br.com.urnawebapi.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.urnawebapi.projeto.model.Eleitor;
import br.com.urnawebapi.projeto.repository.EleitorInterface;

@Service
public class EleitorService {
    
    private EleitorInterface repository;
    private PasswordEncoder passwordEncoder;

    public EleitorService(EleitorInterface repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Eleitor> listarEleitor() {
        List<Eleitor> lista = repository.findAll();
        return lista;
    }

    public Eleitor criarEleitor(Eleitor eleitor) {
        String esconder = this.passwordEncoder.encode(eleitor.getSenha_e());
        eleitor.setSenha_e(esconder);
        Eleitor eleitorNovo = repository.save(eleitor);
        return eleitorNovo;
    }

    public Eleitor editaEleitor(Eleitor eleitor) {
        String esconder = this.passwordEncoder.encode(eleitor.getSenha_e());
        eleitor.setSenha_e(esconder);
        Eleitor eleitorNovo = repository.save(eleitor);
        return eleitorNovo;
    }

    public Boolean excluirEleitor(Integer id_e) {
        repository.deleteById(id_e);
        return true;
    }

    public Boolean validarSenha(Eleitor eleitor) {
        String senha_e = repository.getReferenceById(eleitor.getId_e()).getSenha_e();
        Boolean valido = passwordEncoder.matches(eleitor.getSenha_e(), senha_e);
        return valido;
    }
}
