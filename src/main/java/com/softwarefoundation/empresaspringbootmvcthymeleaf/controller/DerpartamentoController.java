package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("departamento", departamentoService.pesquisarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping(path = "/editar")
    public String editar(Departamento departamento){
        departamentoService.editar(departamento);
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        if(departamentoService.isPossivelExcluir(id)){
            departamentoService.excluir(id);
        }
        return  listar(model);
    }

}
