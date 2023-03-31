package com.example.demo2.Model;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "cliente")
@Data
public class Cliente implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @ManyToOne(targetEntity = Endereco.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Endereco endereco;

}
