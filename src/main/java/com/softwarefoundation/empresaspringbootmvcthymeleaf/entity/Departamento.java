package com.softwarefoundation.empresaspringbootmvcthymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TB01_DEPARTAMENTO")
public class Departamento extends AbstractEntity<Long> {

    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
