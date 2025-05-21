package DAO;

import Classes.Consulta;
import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.util.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultaDAO {

    private Connection conn;

    public ConsultaDAO() {
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
        ArrayList Lista = new ArrayList();

        try {
            String SQL = "SELECT * FROM consultas ";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_consulta = rs.getInt("ID_consulta");
                int id_medico = rs.getInt("id_medico");
                int id_paciente = rs.getInt("id_paciente");
                Date data = rs.getDate("data");
                char compareceu;
                if (rs.getString("compareceu") == null) {
                    compareceu = ' ';
                } else {
                    compareceu = (rs.getString("compareceu")).charAt(0);
                }
                Time hora = rs.getTime("hora");
                
                Lista.add(new Consulta(id_consulta, id_medico, id_paciente, data, hora, compareceu));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }

    public ArrayList listardata(Date dataS) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();

        java.util.Date dataJAVA = dataS;  // Data da classe Java Util
        java.sql.Date dataSQL = new java.sql.Date(dataS.getTime()); // Data da classe SQL

        try {
            String SQL = "SELECT * FROM consultas WHERE data = ? ORDER BY ID_consulta;";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);

            try {
                ps.setDate(1, dataSQL);
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_consulta = rs.getInt("ID_consulta");
                int id_medico = rs.getInt("id_medico");
                int id_paciente = rs.getInt("id_paciente");
                Date data = rs.getDate("data");
                Time hora = rs.getTime("hora");
                char compareceu;
                if (rs.getString("compareceu") == null) {
                    compareceu = ' ';
                } else {
                    compareceu = (rs.getString("compareceu")).charAt(0);
                }

                Lista.add(new Consulta(id_consulta, id_medico, id_paciente, data, hora, compareceu));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }
     
    public void inserir(Consulta consulta) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (consulta == null) {
            System.out.println("O objeto consulta não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO consultas (id_medico,id_paciente,data,hora,compareceu) values (?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, consulta.getId_medico());
            ps.setInt(2, consulta.getId_paciente());
            java.util.Date dataJAVA = consulta.getData();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setTime(4, (Time) consulta.getHora());
            ps.setString(5, Character.toString(consulta.getCompareceu()));
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao inserir uma nova consulta " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public void atualizar(Consulta consulta) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (consulta == null) {
            System.out.println("O objeto consulta não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE consultas set id_medico=?, id_paciente=?, data=?,hora=?, compareceu=? WHERE ID_consulta=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, consulta.getId_medico());
            ps.setInt(2, consulta.getId_paciente());
            java.util.Date dataJAVA = consulta.getData();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setTime(4, (Time) consulta.getHora());
            ps.setString(5, Character.toString(consulta.getCompareceu()));
            ps.setInt(6, consulta.getId_consulta());
            ps.executeUpdate();
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao editar consulta" + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public Consulta procurar(int ID) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Consulta consulta = new Consulta();
        consulta = null;

        try {
            String SQL = "SELECT ID_consulta, id_medico,id_paciente,data,hora,compareceu FROM consultas WHERE ID_consulta = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_consulta = rs.getInt("ID_consulta");
                int id_medico = rs.getInt("id_medico");
                int id_paciente = rs.getInt("id_paciente");
                Date data = rs.getDate("data");
                char compareceu;
                if (rs.getString("compareceu") == null) {
                    compareceu = ' ';
                } else {
                    compareceu = (rs.getString("compareceu")).charAt(0);
                }
                Time hora = rs.getTime("hora");

                consulta = new Consulta(id_consulta, id_medico, id_paciente, data, hora, compareceu);

            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao procurar consulta " + sqle);
        }
        return consulta;
    }

    public void excluir(Consulta consulta) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (consulta == null) {
            System.out.println("O objeto consulta não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM consultas WHERE ID_consulta=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, consulta.getId_consulta());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir consulta " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }
}
