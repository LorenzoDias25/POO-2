package DAO;

import Classes.FuncionarioD;
import Util.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class FDDAO {
    
    private Connection conn;

    public FDDAO() {
        try{
            this.conn = ConexaoBD.getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public ArrayList listartodos() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Exercicio = new ArrayList();

        try{
            String SQL = "SELECT * FROM funcionarios, dependentes where funcionarios.codigo = dependentes.ID_func ORDER BY funcionarios.nome";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

           

            while( rs.next()){
              int func_codigo = rs.getInt("funcionarios.codigo");
              String func_nome = rs.getString("funcionarios.nome");
              Date func_data_nasc = rs.getDate("funcionarios.data_nasc");
              char func_sexo;
              if (rs.getString("funcionarios.sexo") == null) {
                    func_sexo =' ' ;
                }
              else {
                    func_sexo = (rs.getString("funcionarios.sexo")).charAt(0);
                }
              String cpf = rs.getString("funcionarios.cpf");
              
              int dep_ID_dep = rs.getInt("dependentes.ID_dep");
              String dep_nome = rs.getString("dependentes.nome_dep");
              Date data_nasc_dep = rs.getDate("dependentes.data_nasc_dep");
              char dep_sexo;
              if (rs.getString("dependentes.sexo_dep") == null) {
                    dep_sexo =' ' ;
                }
              else {
                    dep_sexo = (rs.getString("dependentes.sexo_dep")).charAt(0);
                }
              int dep_ID_func = rs.getInt("dependentes.ID_func");
              Exercicio.add( new FuncionarioD(func_codigo, func_nome, func_data_nasc, func_sexo, cpf, dep_ID_dep, dep_nome, data_nasc_dep, dep_sexo, dep_ID_func));
              
            }
            
        }catch(SQLException sqle){
          System.out.println(sqle.getMessage());
        }
        finally{
           ConexaoBD.close(connL,ps);
        }
        
        return Exercicio;
    }
    
    public ArrayList listarporfunc(int cod) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList Exercicio = new ArrayList();

        try{
            String SQL = "SELECT * FROM funcionarios, dependentes where dependentes.ID_func = ? ORDER BY funcionarios.nome";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1,cod);
            rs = ps.executeQuery();

           

            while( rs.next()){
              int func_codigo = rs.getInt("funcionarios.codigo");
              String func_nome = rs.getString("funcionarios.nome");
              Date func_data_nasc = rs.getDate("funcionarios.data_nasc");
              char func_sexo;
              if (rs.getString("funcionarios.sexo") == null) {
                    func_sexo =' ' ;
                }
              else {
                    func_sexo = (rs.getString("funcionarios.sexo")).charAt(0);
                }
              String cpf = rs.getString("funcionarios.cpf");
              
              int dep_ID_dep = rs.getInt("dependentes.ID_dep");
              String dep_nome = rs.getString("dependentes.nome_dep");
              Date data_nasc_dep = rs.getDate("dependentes.data_nasc_dep");
              char dep_sexo;
              if (rs.getString("dependentes.sexo_dep") == null) {
                    dep_sexo =' ' ;
                }
              else {
                    dep_sexo = (rs.getString("dependentes.sexo_dep")).charAt(0);
                }
              int dep_ID_func = rs.getInt("dependentes.ID_func");
              Exercicio.add( new FuncionarioD(func_codigo, func_nome, func_data_nasc, func_sexo, cpf, dep_ID_dep, dep_nome, data_nasc_dep, dep_sexo, dep_ID_func));
              
            }
            
        }catch(SQLException sqle){
          System.out.println(sqle.getMessage());
        }
        finally{
           ConexaoBD.close(connL,ps);
        }
        
        return Exercicio;
    }
}
