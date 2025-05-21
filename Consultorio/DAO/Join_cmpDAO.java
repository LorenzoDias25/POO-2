package DAO;

import Classes.Join_CMP;
import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.util.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Join_cmpDAO {

    private Connection conn;

    public Join_cmpDAO() {
        try {
            this.conn = ConexaoBD.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList listarmed(int id) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {
            String SQL = "SELECT ID_consulta,nome_pac,nome_med, data,hora, compareceu FROM consultas, medicos,pacientes WHERE consultas.ID_consulta = medicos.id AND medicos.id = ? ORDER BY consultas.ID_consulta;";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_consulta = rs.getInt("ID_consulta");
                String nome_med = rs.getString("nome_med");
                String nome_pac = rs.getString("nome_pac");
                Date data = rs.getDate("data");
                Time hora = rs.getTime("hora");
                char compareceu;
                if (rs.getString("compareceu") == null) {
                    compareceu = ' ';
                } else {
                    compareceu = (rs.getString("compareceu")).charAt(0);
                }

                Lista.add(new Join_CMP(id_consulta, nome_med, nome_pac, data, hora, compareceu));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }

    public ArrayList listarpac(int id) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();
        try {
            String SQL = "SELECT ID_consulta,nome_pac,nome_med, data,hora, compareceu FROM consultas, medicos,pacientes WHERE pacientes.codigo = consultas.ID_consulta AND pacientes.codigo = ? ORDER BY consultas.ID_consulta;";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_consulta = rs.getInt("ID_consulta");
                String nome_med = rs.getString("nome_med");
                String nome_pac = rs.getString("nome_pac");
                Date data = rs.getDate("data");
                Time hora = rs.getTime("hora");
                char compareceu;
                if (rs.getString("compareceu") == null) {
                    compareceu = ' ';
                } else {
                    compareceu = (rs.getString("compareceu")).charAt(0);
                }

                Lista.add(new Join_CMP(id_consulta, nome_med, nome_pac, data, hora, compareceu));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }

    /*public ArrayList listardata(Date dataS) { // Com join
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Lista = new ArrayList();

        java.util.Date dataJAVA = dataS;  // Data da classe Java Util
        java.sql.Date dataSQL = new java.sql.Date(dataS.getTime()); // Data da classe SQL

        try {
            String SQL = "SELECT ID_consulta,nome_med,nome_pac, data,hora, compareceu FROM consultas,medicos,pacientes WHERE pacientes.codigo = consultas.id_paciente AND medicos.id = consultas.id_medico AND consultas.data = ? ORDER BY ID_consulta";
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
                String nome_med = rs.getString("nome_med");
                String nome_pac = rs.getString("nome_pac");
                Date data = rs.getDate("data");
                Time hora = rs.getTime("hora");
                char compareceu;
                if (rs.getString("compareceu") == null) {
                    compareceu = ' ';
                } else {
                    compareceu = (rs.getString("compareceu")).charAt(0);
                }

                Lista.add(new Join_CMP(id_consulta, nome_med, nome_pac, data, hora, compareceu));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }*/
}
