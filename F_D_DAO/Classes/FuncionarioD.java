
package Classes;

import java.util.Date;


public class FuncionarioD {
    
    int codigo;
    String nome;
    Date data_nasc;
    char sexo;
    String cpf;
    int ID_dep;
    String nome_dep;
    Date data_nasc_dep;
    char sexo_dep;
    int ID_func;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getID_dep() {
        return ID_dep;
    }

    public void setID_dep(int ID_dep) {
        this.ID_dep = ID_dep;
    }

    public String getNome_dep() {
        return nome_dep;
    }

    public void setNome_dep(String nome_dep) {
        this.nome_dep = nome_dep;
    }

    public Date getData_nasc_dep() {
        return data_nasc_dep;
    }

    public void setData_nasc_dep(Date data_nasc_dep) {
        this.data_nasc_dep = data_nasc_dep;
    }

    public char getSexo_dep() {
        return sexo_dep;
    }

    public void setSexo_dep(char sexo_dep) {
        this.sexo_dep = sexo_dep;
    }

    public int getID_func() {
        return ID_func;
    }

    public void setID_func(int ID_func) {
        this.ID_func = ID_func;
    }

    public FuncionarioD() {
    }

    public FuncionarioD(int codigo, String nome, Date data_nasc, char sexo, String cpf, int ID_dep, String nome_dep, Date data_nasc_dep, char sexo_dep, int ID_func) {
        this.codigo = codigo;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.cpf = cpf;
        this.ID_dep = ID_dep;
        this.nome_dep = nome_dep;
        this.data_nasc_dep = data_nasc_dep;
        this.sexo_dep = sexo_dep;
        this.ID_func = ID_func;
    }
    
    
}
