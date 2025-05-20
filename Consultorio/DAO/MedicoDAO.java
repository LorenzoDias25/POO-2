package DAO;

import Classes.Medico;
import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAO {
    
    private Connection conn;

    public MedicoDAO() {
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
            String SQL = "SELECT * FROM medicos ORDER BY id";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome_med = rs.getString("nome_med");
                String especialidade = rs.getString("especialidade");
                Date data_nasc = rs.getDate("data_nasc");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                String fone = rs.getString("fone");
                
                Lista.add(new Medico(id, nome_med, especialidade, data_nasc, sexo,fone));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }

    public void inserir(Medico medico) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (medico == null) {
            System.out.println("O objeto medico não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO medicos (nome_med, especialidade,data_nasc ,sexo,fone) values (?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, medico.getNome_med());
            ps.setString(2, medico.getEspecialidade());
            java.util.Date dataJAVA = medico.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(medico.getSexo()));
            ps.setString(5, medico.getFone());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao inserir um(a) novo medico " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public void atualizar(Medico medico) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (medico == null) {
            System.out.println("O objeto medico não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE medicos set nome_med=?,especialidade=?,data_nasc=?,sexo=?,fone=? WHERE id=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, medico.getNome_med());
            ps.setString(2, medico.getEspecialidade());
            java.util.Date dataJAVA = medico.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(medico.getSexo()));
            ps.setString(5, medico.getFone());
            ps.setInt(6, medico.getId());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao editar medico" + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public Medico procurar(int ID) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Medico medico = new Medico();
        medico = null;

        try {
            String SQL = "SELECT id, nome_med,especialidade, data_nasc, sexo,fone FROM medicos WHERE id = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome_med = rs.getString("nome_med");
                String especialidade = rs.getString("especialidade");
                Date data_nasc = rs.getDate("data_nasc");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                String fone = rs.getString("fone");
                
                medico = new Medico(id, nome_med, especialidade, data_nasc, sexo,fone);

            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao procurar medico " + sqle);
        }
        return medico;
    }

    public void excluir(Medico medico) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (medico == null) {
            System.out.println("O objeto medico não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM medicos WHERE id=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, medico.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir medico " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }
}
