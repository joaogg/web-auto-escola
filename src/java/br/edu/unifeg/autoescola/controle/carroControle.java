/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.controle;

import br.edu.unifeg.autoescola.entidade.Carro;
import br.edu.unifeg.autoescola.modelo.carroDAO;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pein2
 */
@Controller
public class carroControle {

    @RequestMapping("/cadastrarCarro")
    public String inicio(HttpSession session) {
        if (session.getAttribute("pessoaLogin") != null) {
            return "cadastrarCarro";
        } else {
            return "erro";
        }
    }

    @RequestMapping("/submitCarro")
    public String submit(Model model, Carro carro, String submit) {
        String mensagem = "";
        model.addAttribute(carro);
        if (submit.compareTo("Cadastrar") == 0) {
            mensagem = new carroDAO(carro).incluirCarro();
        }
        model.addAttribute(mensagem);
        model.addAttribute(carro);
        return "cadastrarCarro";
    }
}
