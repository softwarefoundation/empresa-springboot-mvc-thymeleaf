package com.softwarefoundation.empresaspringbootmvcthymeleaf.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB02_CARGO")
public class Cargo extends AbstractEntity<Long> {

    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
