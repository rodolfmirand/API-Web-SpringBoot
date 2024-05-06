package br.com.criandoapi.projeto.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.repository.IUsuario;
import br.com.criandoapi.projeto.model.Usuario;

@Service
public class UsuarioService {
    
    private IUsuario repository; 

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Usuario editarUsuario(Usuario usuario) {
        Usuario novoUsuario = repository.save(usuario);
        return novoUsuario;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
