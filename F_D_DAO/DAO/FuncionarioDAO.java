
package DAO;

import Classes.Funcionario;
import Util.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {
    
    private Connection conn;

    public FuncionarioDAO() {
        try{
            this.conn = ConexaoBD.getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Exercicio = new ArrayList();

        try{
            String SQL = "SELECT * FROM funcionarios ORDER BY nome";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

           

            while( rs.next()){
              int codigo = rs.getInt("codigo");
              String nome = rs.getString("nome");
              Date data_nasc = rs.getDate("data_nasc");
              char sexo;
              if (rs.getString("sexo") == null) {
                    sexo =' ' ;
                }
              else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
              String cpf = rs.getString("cpf");
              
              Exercicio.add( new Funcionario(codigo, nome, data_nasc,sexo,cpf));
              
            }

            

        }catch(SQLException sqle){
          System.out.println(sqle.getMessage());
        }
        finally{
           ConexaoBD.close(connL,ps);
        }
        
        return Exercicio;
    }

    public void inserir(Funcionario funcionario) {         
        PreparedStatement ps = null;
        Connection connL = null;        
        if (funcionario == null){
            System.out.println("O objeto funcionario não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO funcionarios (nome, data_nasc, sexo, cpf) values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setString(1, funcionario.getNome());
            java.util.Date dataJAVA = funcionario.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(funcionario.getSexo()));
	    ps.setString(4, funcionario.getCpf());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir um(a) novo funcionario(a) " + sqle);
        }
        finally{
           ConexaoBD.close(connL,ps);
        }
    }
    
    public void atualizar(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (funcionario == null){
             System.out.println("O objeto funcionario não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE funcionarios set nome=?, data_nasc=?,sexo=?, cpf=? WHERE codigo=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL); 
            ps.setString(1, funcionario.getNome());
            java.util.Date dataJAVA = funcionario.getData_nasc();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(2, dataSQL);
            ps.setString(3, Character.toString(funcionario.getSexo()));
            ps.setString(4, funcionario.getCpf());
            ps.setInt(5, funcionario.getCodigo());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar funcionario " + sqle);
        }
        finally{
           ConexaoBD.close(connL,ps);
        }
    }

  
    public Funcionario procurar(int ID) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        funcionario = null;

        try{
            String SQL = "SELECT codigo, nome, data_nasc, sexo, cpf FROM funcionarios WHERE codigo = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
           
            
            while( rs.next()){
              int codigo = rs.getInt("codigo");
              String nome = rs.getString("nome");
              Date data_nasc = rs.getDate("data_nasc");
              char sexo;
              if (rs.getString("sexo") == null) {
                    sexo =' ' ;
                }
              else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
              String cpf = rs.getString("cpf");
                      
              funcionario = new Funcionario(codigo, nome,data_nasc,sexo,cpf);
              
            }
            
            
            
        }catch(SQLException sqle){
            System.out.println("Erro ao procurar funcionario " + sqle);
        }
        return funcionario;
    }   
    
    public void excluir(Funcionario funcionario){
        PreparedStatement ps = null;
        Connection connL = null;
        if (funcionario == null){
           System.out.println("O objeto funcionario não pode ser nulo.");
        }

        try{
            String SQL = "DELETE FROM funcionarios WHERE codigo=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, funcionario.getCodigo());
            ps.executeUpdate();
        }catch(SQLException sqle){
          System.out.println("Erro ao excluir funcionario " + sqle);
        }
        finally{
          ConexaoBD.close(connL,ps);
        }
    }
    
}
