package com.softwarefoundation.empresaspringbootmvcthymeleaf.service;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Endereco;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco pesquisarPorId(Long id){
        Optional<Endereco> optional = enderecoRepository.findById(id);
        return optional.isPresent()? optional.get():null;
    }

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco editar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void excluir(Long id){
        enderecoRepository.deleteById(id);
    }

}
