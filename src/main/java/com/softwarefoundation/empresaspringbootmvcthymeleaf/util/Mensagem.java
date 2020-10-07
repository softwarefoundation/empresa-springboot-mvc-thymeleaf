package com.softwarefoundation.empresaspringbootmvcthymeleaf.util;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

public class Mensagem {

    public static class Sucesso {

        public static void registroSalvoComsucesso(RedirectAttributes attr) {
            if (Objects.nonNull(attr)) {
                attr.addFlashAttribute("success", "Registro salvo com sucesso.");
            }
        }

    }

    public static class Erro {

        public static void registroNaoPodeSerSalvo(RedirectAttributes attr) {
            if (Objects.nonNull(attr)) {
                attr.addFlashAttribute("fail", "Não foi possível salvar o registro");
            }
        }

    }

}
