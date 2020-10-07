package com.softwarefoundation.empresaspringbootmvcthymeleaf.controller.converters;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.entity.Cargo;
import com.softwarefoundation.empresaspringbootmvcthymeleaf.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCargoConverter implements Converter<String, Cargo> {

    @Autowired
    private CargoService cargoService;

    @Override
    public Cargo convert(String id) {
      return id.isEmpty()? null: cargoService.pesquisarPorId(Long.parseLong(id));
    }
}
