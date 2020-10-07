package com.softwarefoundation.empresaspringbootmvcthymeleaf.util;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

public class Mensagem {

    public static class Sucesso {

        public static void salvar(RedirectAttributes attr) {
            if (Objects.nonNull(attr)) {
                attr.addFlashAttribute("success", "Registro salvo com sucesso.");
            }
        }

        public static void excluir(ModelMap attr) {
            if (Objects.nonNull(attr)) {
                if (attr instanceof RedirectAttributes) {
                    RedirectAttributes redirectAttributes = (RedirectAttributes) attr;
                    redirectAttributes.addFlashAttribute("success", "Registro excluído com sucesso.");
                } else {
                    attr.addAttribute("success", "Registro excluído com sucesso.");
                }
            }
        }

    }

    public static class Erro {

        public static void registroNaoPodeSerSalvo(RedirectAttributes attr) {
            if (Objects.nonNull(attr)) {
                attr.addFlashAttribute("fail", "Não foi possível salvar o registro");
            }
        }

        public static void excluir(ModelMap attr) {
            if (Objects.nonNull(attr)) {
                if (attr instanceof RedirectAttributes) {
                    RedirectAttributes redirectAttributes = (RedirectAttributes) attr;
                    redirectAttributes.addFlashAttribute("fail", "Não foi possível salvar o registro");
                }else{
                    attr.addAttribute("fail", "Não foi possível excluir o registro");
                }
            }
        }

    }

}
