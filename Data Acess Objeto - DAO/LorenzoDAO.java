
package DAO.DAO;

import DAO.Classes.Lorenzo;
import DAO.Util.conexaoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class LorenzoDAO {
    
    private Connection conn;
    
    public LorenzoDAO(){
        try {
            this.conn = conexaoDAO.getConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro de conexao: " + "\n" + e.getMessage());
        }
    }
    
    public ArrayList listar(){
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Agenda = new ArrayList();
        
        try {
            String SQL = "SELECT * FROM pessoas";
            connL = this.conn;
            
            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int ID_Pessoa = rs.getInt("ID_Pessoa");
                String nome = rs.getString("nome");
                char sexo;
                if (rs.getString("sexo") == null){
                    sexo = ' ';
                } else {
                 sexo = (rs.getString("sexo")).charAt(0);
                }
                Date dataNasc = rs.getDate("dataNasc");
                String nacionalidade = rs.getString("nacionalidade");
                
                Agenda.add(new Lorenzo(ID_Pessoa,nome,sexo,dataNasc,nacionalidade));
            }
        } catch (SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro ao listar agenda " + sqle);
        } finally {
            conexaoDAO.close(connL,ps);
        }
        
        return Agenda;
    }
    
    public void inserir(Lorenzo lorenzo){
        PreparedStatement ps = null;
        Connection connL = null;
        if (lorenzo == null){
            JOptionPane.showMessageDialog(null, "O objeto pessoa não pode ser nulo !!!");
        }
        try {
            String SQL = "INSERT INTO pessoas (nome, sexo, dataNasc, nacionalidade) values(?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, lorenzo.getNome());
            ps.setString(2, Character.toString(lorenzo.getSexo()));
            java.util.Date dataJAVA = lorenzo.getDataNasc();
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime());
            ps.setDate(3, dataSQL);
            ps.setString(4, lorenzo.getNacionalidade());
            ps.executeUpdate();
        } catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir uma nova pessoa" + sqle);
        } finally{
            conexaoDAO.close(connL, ps);
        }
    }
}
