package br.com.criandoapi.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

//lombok construtores, getters e settes
@Data

@Entity
@Table(name = "usuario")
public class Usuario {

    /* informa que é chave primária
     * informa que o campo é auto incrematado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Integer id;

    /* configura tamanho e não poder ser nulo */
    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome precisa ter no mínimo 3 caracteres.")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email(message = "Insira um e-mail válido!")
    @NotBlank(message = "O e-mail é obrigatório! ")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatório!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;
}
