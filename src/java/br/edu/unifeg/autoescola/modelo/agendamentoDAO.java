/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifeg.autoescola.modelo;

import br.edu.unifeg.autoescola.entidade.Agendamento;
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
public class agendamentoDAO {

    private Agendamento a;
    private conexao con;
    private String mensagem;

    public agendamentoDAO(Agendamento a) {
        this.a = a;
        con = new conexao();
    }

    public agendamentoDAO() {
        con = new conexao();
    }

    public String incluirAgendamento() {
        String sql = "INSERT INTO AGENDAMENTO (CPFALUNO, CPFINSTRUTOR, DATA, SITUACAO)"
                + " values ('" + a.getCpf_aluno() + "', '" + a.getCpf_intrutor() + "', '" + a.getData() + "', '" + a.getSituacao() + "')";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Agendamento INCLUSO com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Agendamento NAO foi INCLUSO!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public boolean verificarData() throws SQLException {
        con.iniciaConexao();
        String sql = "SELECT * FROM AGENDAMENTO WHERE DATA='" + a.getData() + "'";
        ResultSet rs = con.stmt.executeQuery(sql);

        boolean result = false;

        while (rs.next()) {
            result = true;
        }
        con.fechaConexao();
        return result;
    }

    public int somaAulasConfirmadas(String cpf, String pessoa) throws SQLException {
        con.iniciaConexao();
        String sql;

        if (pessoa.equalsIgnoreCase("I")) {
            sql = "SELECT COUNT(ID) FROM AGENDAMENTO WHERE CPFINSTRUTOR='" + cpf + "' AND SITUACAO='Concluida'";
        } else {
            sql = "SELECT COUNT(ID) FROM AGENDAMENTO WHERE CPFALUNO='" + cpf + "' AND SITUACAO='Concluida'";
        }

        ResultSet rs = con.stmt.executeQuery(sql);
        int result = 0;

        while (rs.next()) {
            result = rs.getInt("COUNT(ID)");
        }
        con.fechaConexao();
        return result;
    }

    public int somaAulasCanceladas(String cpf, String pessoa) throws SQLException {
        con.iniciaConexao();
        String sql;

        if (pessoa.equalsIgnoreCase("I")) {
            sql = "SELECT COUNT(ID) FROM AGENDAMENTO WHERE CPFINSTRUTOR='" + cpf + "' AND SITUACAO='Cancelada'";
        } else {
            sql = "SELECT COUNT(ID) FROM AGENDAMENTO WHERE CPFALUNO='" + cpf + "' AND SITUACAO='Cancelada'";
        }

        ResultSet rs = con.stmt.executeQuery(sql);
        int result = 0;

        while (rs.next()) {
            result = rs.getInt("COUNT(ID)");
        }
        con.fechaConexao();
        return result;
    }  
    
    public int somaAulasAguardando(String cpf, String pessoa) throws SQLException {
        con.iniciaConexao();
        String sql;

        if (pessoa.equalsIgnoreCase("I")) {
            sql = "SELECT COUNT(ID) FROM AGENDAMENTO WHERE CPFINSTRUTOR='" + cpf + "' AND SITUACAO='Confirmada'";
        } else {
            sql = "SELECT COUNT(ID) FROM AGENDAMENTO WHERE CPFALUNO='" + cpf + "' AND SITUACAO='Confirmada'";
        }

        ResultSet rs = con.stmt.executeQuery(sql);
        int result = 0;

        while (rs.next()) {
            result = rs.getInt("COUNT(ID)");
        }
        con.fechaConexao();
        return result;
    }      
    
    public List<Agendamento> meusAgendamentos(String cpf, int pessoa) {
        con.iniciaConexao();
        List<Agendamento> lista = new ArrayList();

        String sql = "";

        if (pessoa == 1) {
            sql = "SELECT * FROM AGENDAMENTO WHERE CPFALUNO='" + cpf + "' ORDER BY SITUACAO DESC";
        } else {
            sql = "SELECT * FROM AGENDAMENTO WHERE CPFINSTRUTOR='" + cpf + "' AND SITUACAO!='Concluida' ORDER BY DATA ASC";
        }
        System.out.println(sql);
        try {
            ResultSet rs = con.stmt.executeQuery(sql);
            while (rs.next()) {
                Agendamento a = new Agendamento();
                a.setData(rs.getString("DATA"));
                a.setId(rs.getInt("ID"));
                a.setSituacao(rs.getString("SITUACAO"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
        return lista;
    }

    public List<Agendamento> todosAgendamentos() {
        con.iniciaConexao();
        List<Agendamento> lista = new ArrayList();
        String sql = "SELECT * FROM AGENDAMENTO WHERE SITUACAO='Aguardando' ORDER BY DATA ASC";
        System.out.println(sql);
        try {
            ResultSet rs = con.stmt.executeQuery(sql);
            while (rs.next()) {
                Agendamento a = new Agendamento();
                a.setData(rs.getString("DATA"));
                a.setId(rs.getInt("ID"));
                a.setSituacao(rs.getString("SITUACAO"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
        return lista;
    }

    public String confirmarAgendamento() {
        String sql = "UPDATE AGENDAMENTO SET SITUACAO='" + a.getSituacao() + "' WHERE ID='" + a.getId() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Aula ALTERADA com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Aula NAO foi ALTERADA!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String cancelarAgendamento() {
        String sql = "UPDATE AGENDAMENTO SET SITUACAO='Cancelada' WHERE ID='" + a.getId() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Aula ALTERADA com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Aula NAO foi ALTERADA!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String concluirAgendamento() {
        String sql = "UPDATE AGENDAMENTO SET SITUACAO='Concluida' WHERE ID='" + a.getId() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Aula ALTERADA com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Aula NAO foi ALTERADA!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String excluirAgendamento() {
        String sql = "DELETE FROM AGENDAMENTO WHERE id='" + a.getId() + "'";

        System.out.println(sql);
        con.iniciaConexao();
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Aula EXCLUIDA com SUCESSO!";
        } catch (SQLException ex) {
            Logger.getLogger(agendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Aula NAO foi EXCLUIDA!";
        }
        con.fechaConexao();
        return mensagem;

    }
}
