/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.modelo;

import br.edu.unifeg.autoescola.entidade.Contato;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pein2
 */
public class contatoDAO {

   private Contato c;
   private conexao con;
   private String mensagem;    
   

    public contatoDAO(Contato c) {
        this.c = c;
        con = new conexao();
    } 
    
    public contatoDAO() {
        con = new conexao();
    } 
 
    public String incluirContato(){
        String sql = "INSERT INTO CONTATO (NOME, EMAIL, CONTATO)"
                + " values ('"+c.getNome()+"', '"+c.getEmail()+"', '"+c.getContato()+"')";
        
        System.out.println(sql);
        con.iniciaConexao();
       try {
           con.stmt.executeUpdate(sql);
           mensagem = "Contato INCLUSO com SUCESSO!";
       } catch (SQLException ex) {
           Logger.getLogger(contatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Contato NAO foi INCLUSO!";
       }
       con.fechaConexao();
       return mensagem;        
    }    
}
