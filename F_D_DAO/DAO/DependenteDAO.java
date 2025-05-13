package DAO;

import Classes.Dependente;
import Util.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DependenteDAO {

    private Connection conn;

    public DependenteDAO() {
        try {
            this.conn = ConexaoBD.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Exercicio = new ArrayList();

        try {
            String SQL = "SELECT * FROM dependentes ORDER BY ID_dep";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_dep = rs.getInt("ID_dep");
                String nome_dep = rs.getString("nome_dep");
                Date data_nasc_dep = rs.getDate("data_nasc_dep");
                char sexo_dep;
                if (rs.getString("sexo_dep") == null) {
                    sexo_dep = ' ';
                } else {
                    sexo_dep = (rs.getString("sexo_dep")).charAt(0);
                }
                int ID_func = rs.getInt("ID_func");

                Exercicio.add(new Dependente(ID_dep, nome_dep, data_nasc_dep, sexo_dep, ID_func));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Exercicio;
    }

    public void inserir(Dependente dependente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (dependente == null) {
            System.out.println("O objeto dependente não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO dependentes (nome_dep, data_nasc_dep, sexo_dep,ID_func) values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, dependente.getNome_dep());
            java.util.Date dataJAVA = dependente.getData_nasc_dep();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(dependente.getSexo_dep()));
            ps.setInt(4, dependente.getID_func());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao inserir um(a) novo dependente " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public void atualizar(Dependente dependente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (dependente == null) {
            System.out.println("O objeto dependente não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE dependentes set nome_dep=?, data_nasc_dep=?,sexo_dep=? WHERE ID_dep=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, dependente.getNome_dep());
            java.util.Date dataJAVA = dependente.getData_nasc_dep();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(dependente.getSexo_dep()));
            ps.setInt(4, dependente.getID_dep());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao editar dependente " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public Dependente procurar(int ID) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Dependente dependente = new Dependente();
        dependente = null;

        try {
            String SQL = "SELECT * FROM dependentes WHERE ID_func = ?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_dep = rs.getInt("ID_dep");
                String nome_dep = rs.getString("nome_dep");
                Date data_nasc_dep = rs.getDate("data_nasc_dep");
                char sexo_dep;
                if (rs.getString("sexo_dep") == null) {
                    sexo_dep = ' ';
                } else {
                    sexo_dep = (rs.getString("sexo_dep")).charAt(0);
                }
                int ID_func = rs.getInt("ID_func");
                
                dependente = new Dependente(ID_dep, nome_dep, data_nasc_dep, sexo_dep, ID_func);

            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao listar dependentes " + sqle);
        } finally {
            // ConexaoAulaDAO.close(connL, ps);
        }
        return dependente;
    }

    public void excluir(Dependente dependente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (dependente == null) {
            System.out.println("O objeto dependente não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM dependentes WHERE ID_dep=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, dependente.getID_dep());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir dependente " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

}
