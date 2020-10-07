package com.softwarefoundation.empresaspringbootmvcthymeleaf.service;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Funcionario;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento pesquisarPorId(Long id) {
        Optional<Departamento> optional = departamentoRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento editar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void excluir(Long id) {
        departamentoRepository.deleteById(id);
    }

    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean isPossivelExcluir(Long id) {
        try {
            return pesquisarPorId(id).getCargos().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
