package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Cargo;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Funcionario;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.UF;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.CargoService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.DepartamentoService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.FuncionarioService;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.listar());
        return "funcionario/lista";
    }

    @PostMapping(path = "salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.salvar(funcionario);
        Mensagem.Sucesso.salvar(attr);
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping(path = "/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.pesquisarPorId(id));
        return "/funcionario/cadastro";
    }

    @PostMapping(path = "/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr) {
        funcionarioService.editar(funcionario);
        Mensagem.Sucesso.salvar(attr);
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        funcionarioService.excluir(id);
        Mensagem.Sucesso.excluir(model);
        return listar(model);
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return cargoService.listar();
    }

    @ModelAttribute("ufs")
    public UF[] getUFs() {
        return UF.values();
    }
}
