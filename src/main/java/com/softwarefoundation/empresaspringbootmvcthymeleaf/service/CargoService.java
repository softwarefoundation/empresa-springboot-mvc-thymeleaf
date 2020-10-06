package com.softwarefoundation.empresaspringbootmvcthymeleaf.service;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Cargo;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Funcionario;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo pesquisarPorId(Long id){
        Optional<Cargo> optional = cargoRepository.findById(id);
        return optional.isPresent()? optional.get():null;
    }

    public Cargo salvar(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public Cargo editar(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public void excluir(Long id){
        cargoRepository.deleteById(id);
    }

}
