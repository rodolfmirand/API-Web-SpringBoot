package br.com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoapi.projeto.model.Usuario;
/* CrudRepository adiciona métodos à interface */
public interface IUsuario extends JpaRepository<Usuario, Integer>{
    
}
