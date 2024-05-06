package br.com.criandoapi.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.repository.IUsuario;
import br.com.criandoapi.projeto.model.Usuario;

@Service
public class UsuarioService {
    
    private IUsuario repository; 
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        //retorna a senha cryptografada e já salva no usuario
        usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario editarUsuario(Usuario usuario) {
        //retorna a senha cryptografada e já salva no usuario
        usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getReferenceById(usuario.getId()).getSenha();
        return passwordEncoder.matches(usuario.getSenha(), senha);
    }
}
