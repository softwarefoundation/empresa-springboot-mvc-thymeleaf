package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Cargo;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.CargoService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.DepartamentoService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping(path = "/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargo", cargoService.pesquisarPorId(id));
        return "/cargo/cadastro";
    }

    @PostMapping(path = "/editar")
    public String editar(Cargo cargo, RedirectAttributes attr){
        cargoService.editar(cargo);
        Mensagem.Sucesso.registroSalvoComsucesso(attr);
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping(path = "/listar")
    public String listar(ModelMap model){
        model.addAttribute("cargos",cargoService.listar());
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
