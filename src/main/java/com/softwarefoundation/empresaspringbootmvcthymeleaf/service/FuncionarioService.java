package com.softwarefoundation.empresaspringbootmvcthymeleaf.service;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Funcionario;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario pesquisarPorId(Long id){
        Optional<Funcionario> optional = funcionarioRepository.findById(id);
        return optional.isPresent()? optional.get():null;
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario editar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void excluir(Long id){
        funcionarioRepository.deleteById(id);
    }

}
