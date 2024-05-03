package br.com.criandoapi.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoapi.projeto.model.Usuario;
/* CrudRepository adiciona métodos à interface */
public interface IUsuario extends CrudRepository<Usuario, Integer>{
    
}
