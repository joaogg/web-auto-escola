/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.modelo;

import br.edu.unifeg.autoescola.entidade.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pein2
 */
public class pessoaDAO {

    private Pessoa p;
    private conexao con;
    private String mensagem;

    public pessoaDAO(Pessoa p) {
        this.p = p;
        con = new conexao();
    }

    public pessoaDAO() {
        con = new conexao();
    }    
    
    public Pessoa consultarPessoa(String cpf) {
        con.iniciaConexao();
        String sql = "SELECT * FROM PESSOA WHERE CPF='" + cpf + "'";
        System.out.println(sql);
        try {
            ResultSet rs = con.stmt.executeQuery(sql);
            if (rs.next()) {
                p.setCpf(rs.getString("cpf"));
                p.setDatanascimento(rs.getString("datanascimento"));
                p.setNome(rs.getString("nome"));
                p.setRg(rs.getString("rg"));
                p.setSenha(rs.getString("senha"));
                p.setTipoconta(rs.getString("tipoconta"));
                p.setImagem(rs.getString("imagem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
        return p;
    }

    public Pessoa login() {
        con.iniciaConexao();
        String sql = "select * from pessoa where cpf='" + p.getCpf() + "' and senha=SHA('" + p.getSenha() + "')";
        System.out.println(sql);
        try {
            ResultSet rs = con.stmt.executeQuery(sql);
            if (rs.next()) {
                p.setCpf(rs.getString("cpf"));
                p.setNome(rs.getString("nome"));
                p.setLogin(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
        return p;
    }

    public String incluirPessoa() {
        con.iniciaConexao();

        String sql = "INSERT INTO PESSOA (CPF, RG, NOME, SENHA, DATANASCIMENTO, TIPOCONTA)"
                + " values ('" + p.getCpf() + "', '" + p.getRg() + "', '" + p.getNome() + "', SHA('" + p.getSenha() + "'), '" + p.getDatanascimento() + "', '" + p.getTipoconta() + "')";

        System.out.println(sql);
        try {
            con.stmt.executeUpdate(sql);
            mensagem = " Pessoa incluido com sucesso.";

        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = " Pessoa não pode ser incluido.";
        }
        return mensagem;

    }

    public String alterarPessoa() {
        String sql = "UPDATE PESSOA SET NOME='" + p.getNome() + "', SENHA='" + p.getSenha() + "', RG='" + p.getRg() + "',"
                + " DATANASCIMENTO='" + p.getDatanascimento() + "', TIPOCONTA='" + p.getTipoconta() + "' "
                + "WHERE CPF='" + p.getCpf() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Pessoa ALTERADA com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Pessoa NAO foi ALTERADA!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String deletePessoa() {
        String sql = "DELETE FROM PESSOA WHERE CPF='" + p.getCpf() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Pessoa EXCLUIDA com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Pessoa NAO foi EXCLUIDA!";
        }
        con.fechaConexao();
        return mensagem;

    }

    public List<Pessoa> dadosUsuario(String sessao) {
        con.iniciaConexao();
        List<Pessoa> lista = new ArrayList();
        String sql = "SELECT * FROM PESSOA WHERE CPF='" + sessao + "'";
        System.out.println(sql);
        try {
            ResultSet rs = con.stmt.executeQuery(sql);
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setCpf(rs.getString("CPF"));
                p.setRg(rs.getString("RG"));
                p.setNome(rs.getString("NOME"));
                p.setDatanascimento(rs.getString("DATANASCIMENTO"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
        return lista;
    }

    public List<Pessoa> dadosInstrutor() {
        con.iniciaConexao();
        List<Pessoa> lista = new ArrayList();
        String sql = "SELECT * FROM PESSOA WHERE TIPOCONTA='I'";
        System.out.println(sql);
        try {
            ResultSet rs = con.stmt.executeQuery(sql);
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setCpf(rs.getString("CPF"));
                p.setNome(rs.getString("NOME"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
        return lista;
    }

    public Pessoa dadosPessoa(String cpf) throws SQLException {
        con.iniciaConexao();
        String sql = "SELECT * FROM PESSOA WHERE CPF='" + cpf + "'";
        ResultSet rs = con.stmt.executeQuery(sql);

        Pessoa p = new Pessoa();
        while (rs.next()) {
            p.setCpf(rs.getString("CPF"));
            p.setRg(rs.getString("RG"));
            p.setNome(rs.getString("NOME"));
            p.setDatanascimento(rs.getString("DATANASCIMENTO"));
            p.setTipoconta(rs.getString("TIPOCONTA"));
            p.setImagem(rs.getString("IMAGEM"));
        }
        con.fechaConexao();
        return p;
    }
}
