/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.modelo;

/**
 *
 * @author pein2
 */
import java.sql.*;
public class conexao {
    private String URLConexao;
    private String DriverConexao;
    private Connection Conexao;
    public Statement stmt;

   public conexao()
    {
           URLConexao="jdbc:mysql://localhost:3306/progweb?user=root&password=123456&autoReconnect=true";
           DriverConexao="com.mysql.jdbc.Driver";
    }
    public conexao(String BancoDados,String IpHost)
    {
           URLConexao="jdbc:mysql://"+IpHost+":3306/"+BancoDados+"?user=root&password=123456&autoReconnect=true";
           DriverConexao="org.gjt.mm.mysql.Driver";
    }
  public void iniciaConexao()
  {
    try
    {
      	Class.forName (DriverConexao);
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("Erro na criaÎ’o do Dirver"+e+'\t');
    }
    try
    {
    	 Conexao = DriverManager.getConnection(URLConexao);
        stmt = Conexao.createStatement();
        System.out.println("Iniciando conexao com o Banco de Dados");
    }
    catch(SQLException e)
    {
      	System.out.println("Erro Na conexao com o Banco de Dados"+e+'\t');

              System.out.println("SQLException: " + e.getMessage());
              System.out.println("SQLState:     " + e.getSQLState());
              System.out.println("VendorError:  " + e.getErrorCode());
    }
  }
  public void fechaConexao()
  {
    try
    {
          stmt.close();
          Conexao.close();
      	  System.out.println("Fechando conexao com o Banco de Dados");
     }
     catch(SQLException e)
     {
      	System.out.println("Erro Na conexao com o Banco de Dados"+e+'\t');
     }
  }

}

