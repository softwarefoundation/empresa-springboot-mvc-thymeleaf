package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Departamento;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public Departamento convert(String id) {
      return id.isEmpty()? null:departamentoService.pesquisarPorId(Long.parseLong(id));
    }
}
