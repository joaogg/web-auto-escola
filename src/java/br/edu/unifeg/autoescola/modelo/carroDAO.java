/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.modelo;

import br.edu.unifeg.autoescola.entidade.Carro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pein2
 */
public class carroDAO {

    private Carro c;
    private conexao con;
    private String mensagem;

    public carroDAO(Carro c) {
        this.c = c;
        con = new conexao();
    }

    public String incluirCarro() {
        String sql = "INSERT INTO CARROS ( placa, modelo, ano, marca)"
                + " values ('" + c.getPlaca() + "', '" + c.getModelo() + "', '" + c.getAno() + "', '" + c.getMarca() + "')";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Carro INCLUSO com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Carro NAO foi INCLUSO!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String alterarCarro() {
        String sql = "UPDATE CARROS SET MODELO='" + c.getModelo() + "', ano='" + c.getAno() + "',MARCA='" + c.getMarca() + "',"
                + "WHERE PLACA='" + c.getPlaca() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Carro ALTERADO com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Carro NAO foi ALTERADO!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String deleteCarro() {
        String sql = "DELETE FROM CARROS WHERE PLACA='" + c.getPlaca() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Carro EXCLUIDO com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(carroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Carro NAO foi EXCLUIDO!";
        }
        con.fechaConexao();
        return mensagem;

    }

}
