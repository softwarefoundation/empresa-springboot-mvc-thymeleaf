package com.softwarefoundation.empresaspringbootmvcthymeleaf.repository;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
