/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.controle;

import br.edu.unifeg.autoescola.entidade.Contato;
import br.edu.unifeg.autoescola.modelo.contatoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pein2
 */
@Controller
public class contatoControle {

    @RequestMapping("/contato")
    public String contato() {
        return "contato";
    }

    @RequestMapping("/submitContato")
    public String submit(Model model, Contato contato, String submit) {
        String mensagem = "";
        model.addAttribute(contato);
        if (submit.compareTo("Cadastrar") == 0) {
            mensagem = new contatoDAO(contato).incluirContato();
        }
        model.addAttribute(mensagem);
        model.addAttribute(contato);
        return "contato";
    }
}
