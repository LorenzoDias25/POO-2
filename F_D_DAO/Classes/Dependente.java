
package Classes;

import java.util.Date;


public class Dependente {
    
    int ID_dep;
    String nome_dep;
    Date data_nasc_dep;
    char sexo_dep;
    int ID_func;

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

    public Dependente() {
    }

    public Dependente(String nome_dep, Date data_nasc_dep, char sexo_dep, int ID_func) {
        this.nome_dep = nome_dep;
        this.data_nasc_dep = data_nasc_dep;
        this.sexo_dep = sexo_dep;
        this.ID_func = ID_func;
    }

    public Dependente(int ID_dep, String nome_dep, Date data_nasc_dep, char sexo_dep, int ID_func) {
        this.ID_dep = ID_dep;
        this.nome_dep = nome_dep;
        this.data_nasc_dep = data_nasc_dep;
        this.sexo_dep = sexo_dep;
        this.ID_func = ID_func;
    }
    
    
}
