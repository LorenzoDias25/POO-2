package DAO;

import Classes.Paciente;
import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO {

    private Connection conn;

    public PacienteDAO() {
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
            String SQL = "SELECT * FROM pacientes ORDER BY codigo";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome_pac = rs.getString("nome_pac");
                String fone = rs.getString("fone");
                Date data_nasc = rs.getDate("data_nasc");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }

                Lista.add(new Paciente(codigo, nome_pac, fone, data_nasc, sexo));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoBD.close(connL, ps);
        }

        return Lista;
    }

    public void inserir(Paciente paciente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (paciente == null) {
            System.out.println("O objeto paciente não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO pacientes (nome_pac, fone ,data_nasc ,sexo) values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, paciente.getNome_pac());
            ps.setString(2, paciente.getFone());
            java.util.Date dataJAVA = paciente.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(paciente.getSexo()));
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao inserir um(a) novo paciente " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public void atualizar(Paciente paciente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (paciente == null) {
            System.out.println("O objeto paciente não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE pacientes set nome_pac=?,fone=?,data_nasc=?,sexo=? WHERE codigo=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, paciente.getNome_pac());
            ps.setString(2, paciente.getFone());
            java.util.Date dataJAVA = paciente.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(3, dataSQL);
            ps.setString(4, Character.toString(paciente.getSexo()));
            ps.setInt(5, paciente.getCodigo());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Erro ao editar paciente " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }

    public Paciente procurar(int ID) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Paciente paciente = new Paciente();
        paciente = null;

        try {
            String SQL = "SELECT codigo, nome_pac,fone, data_nasc, sexo FROM pacientes WHERE codigo = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome_pac = rs.getString("nome_pac");
                String fone = rs.getString("fone");
                Date data_nasc = rs.getDate("data_nasc");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }

                paciente = new Paciente(codigo, nome_pac, fone, data_nasc, sexo);

            }

        } catch (SQLException sqle) {
            System.out.println("Erro ao procurar paciente " + sqle);
        }
        return paciente;
    }

    public void excluir(Paciente paciente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (paciente == null) {
            System.out.println("O objeto paciente não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM pacientes WHERE codigo=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, paciente.getCodigo());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir paciente " + sqle);
        } finally {
            ConexaoBD.close(connL, ps);
        }
    }
}
