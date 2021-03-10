/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.controle;

import br.edu.unifeg.autoescola.entidade.Agendamento;
import br.edu.unifeg.autoescola.modelo.agendamentoDAO;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pein2
 */
@Controller
public class agendamentoControle {
  
    @RequestMapping("/cadastrarAgendamento")
    public String cadastrarAgendamento(HttpSession session) {
        if (session.getAttribute("pessoaLogin") != null) {
            return "cadastrarAgendamento";
        } else {
            return "erro";
        }
    }
    
    @RequestMapping("/avaliarAgendamento")
    public String avaliarAgendamento(HttpSession session) {
        if (session.getAttribute("pessoaLogin") != null) {
            return "avaliarAgendamento";
        } else {
            return "erro";
        }
    }
    
    @RequestMapping("/submitAgendamento")
    public String submit(Model model, Agendamento agendamento, String submit) {
        String mensagem = "";
        model.addAttribute(agendamento);
        if (submit.compareTo("Cadastrar") == 0) {
            mensagem = new agendamentoDAO(agendamento).incluirAgendamento();
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute(agendamento);
        return "cadastrarAgendamento";
    }  
    
    @RequestMapping("/submitSituacao")
    public String submitSituacao(Model model, Agendamento agendamento, String submit) {
        String mensagem = "";
        model.addAttribute(agendamento);
        if (submit.compareTo("Cadastrar") == 0) {
            mensagem = new agendamentoDAO(agendamento).confirmarAgendamento();
        }
        model.addAttribute(mensagem);
        model.addAttribute(agendamento);
        return "avaliarAgendamento";
    }  
    
    @RequestMapping("/submitSituacaoAluno")
    public String submitSituacaoAluno(Model model, Agendamento agendamento, String submit) {
        String mensagem = "";
        model.addAttribute(agendamento);
        if (submit.compareTo("Cadastrar") == 0) {
            mensagem = new agendamentoDAO(agendamento).confirmarAgendamento();
        }
        model.addAttribute(mensagem);
        model.addAttribute(agendamento);
        return "perfil";
    }      
}
