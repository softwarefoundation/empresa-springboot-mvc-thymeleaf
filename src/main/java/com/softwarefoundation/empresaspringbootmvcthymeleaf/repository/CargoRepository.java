package com.softwarefoundation.empresaspringbootmvcthymeleaf.repository;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Long> {
}
