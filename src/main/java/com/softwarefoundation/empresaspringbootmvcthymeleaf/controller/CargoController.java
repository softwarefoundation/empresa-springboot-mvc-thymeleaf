package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Cargo;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.CargoService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.DepartamentoService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(path = "/cadastrar")
    public String cadastrar(Cargo cargo){
        return "/cargo/cadastro";
    }

    @GetMapping(path = "/listar")
    public String listar(){
        return "/cargo/lista";
    }

    @PostMapping(path = "/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr){
        cargoService.salvar(cargo);
        Mensagem.Sucesso.registroSalvoComsucesso(attr);
        return "redirect:/cargos/cadastrar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.listar();
    }

}
