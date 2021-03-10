/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.controle;

import br.edu.unifeg.autoescola.entidade.Pessoa;
import br.edu.unifeg.autoescola.modelo.pessoaDAO;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pein2
 */
@Controller
public class pessoaControle {

    @RequestMapping("/cadastrarPessoa")
    public String inicio(HttpSession session) {
        if (session.getAttribute("pessoaLogin") != null) {
            return "cadastrarPessoa";
        } else {
            return "erro";
        }
    }
    
    @RequestMapping("/perfil")
    public String perfil(HttpSession session) {
        if (session.getAttribute("pessoaLogin") != null) {
            return "perfil";
        } else {
            return "erro";
        }
    }

    @RequestMapping("/index")
    public String login() {
        return "index";
    }

    @RequestMapping("/submit")
    public String submit(Model model, Pessoa pessoa, String submit) {
        String mensagem = "";
        model.addAttribute(pessoa);
        if (submit.compareTo("Cadastrar") == 0) {
            mensagem = new pessoaDAO(pessoa).incluirPessoa();
        }
        model.addAttribute(mensagem);
        model.addAttribute(pessoa);
        return "cadastrarPessoa";
    }

    @RequestMapping("/acessar")
    public String login(Model model, Pessoa pessoa, HttpSession session) {
        pessoa = new pessoaDAO(pessoa).login();
        if (pessoa.isLogin()) {
            session.setAttribute("pessoaLogin", pessoa.getCpf());
            return "perfil";
        } else {
            model.addAttribute("msg", "Login incorreto!");
            return "index";
        }
    }
}
