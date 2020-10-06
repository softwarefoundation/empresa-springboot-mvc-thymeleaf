package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DerpartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("cadastrar")
    public String cadastrar(Departamento departamento) {
        return "departamento/cadastro";
    }

    @GetMapping("listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos",departamentoService.listar());
        return "departamento/lista";
    }

    @PostMapping(path = "salvar")
    public String salvar(Departamento departamento){
        departamentoService.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }

}
