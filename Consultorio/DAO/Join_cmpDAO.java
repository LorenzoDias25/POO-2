package DAO;

import Classes.Join_CMP;
import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Join_cmpDAO {
    
    private Connection conn;

    public Join_cmpDAO() {
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
            String SQL = "SELECT ID_consulta,nome_pac,nome_med, data,hora, compareceu FROM consultas, medicos,pacientes WHERE pacientes.codigo = consultas.id_paciente and medicos.id = ID_consulta ORDER BY ID_consulta;";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
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
                
                Lista.add(new Join_CMP(id_consulta, nome_med, nome_pac, data,hora, compareceu));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }

}
