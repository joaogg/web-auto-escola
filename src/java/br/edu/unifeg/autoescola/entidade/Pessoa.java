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
public class Pessoa {

    private String cpf;
    private String nome;
    private String imagem;
    private String rg;
    private String senha;
    private String datanascimento;
    private String tipoconta;
    private boolean login;

    public Pessoa() {
        login = false;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getTipoconta() {
        return tipoconta;
    }

    public void setTipoconta(String tipoconta) {
        this.tipoconta = tipoconta;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }    
    

    @Override
    public String toString() {
        return "nome=" + nome + "&cpf=" + cpf + "&rg=" + rg + "&datanascimento=" + datanascimento + "&tipoconta=" + tipoconta + "&senha=" + senha;
    }

}
