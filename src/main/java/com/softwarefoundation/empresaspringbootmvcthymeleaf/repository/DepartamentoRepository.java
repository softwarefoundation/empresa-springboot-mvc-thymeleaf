package com.softwarefoundation.empresaspringbootmvcthymeleaf.repository;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
