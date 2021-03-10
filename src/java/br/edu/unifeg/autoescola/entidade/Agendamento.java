/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.entidade;

/**
 *
 * @author pein2
 */
public class Agendamento {

    private int id;
    private String cpf_aluno;
    private String cpf_intrutor;
    private String placa_carro;
    private String data;
    private String situacao;

    public Agendamento(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf_aluno() {
        return cpf_aluno;
    }

    public void setCpf_aluno(String cpf_aluno) {
        this.cpf_aluno = cpf_aluno;
    }

    public String getCpf_intrutor() {
        return cpf_intrutor;
    }

    public void setCpf_intrutor(String cpf_intrutor) {
        this.cpf_intrutor = cpf_intrutor;
    }

    public String getPlaca_carro() {
        return placa_carro;
    }

    public void setPlaca_carro(String placa_carro) {
        this.placa_carro = placa_carro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
