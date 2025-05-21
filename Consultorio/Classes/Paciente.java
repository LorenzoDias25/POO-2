package Classes;

import java.util.Date;

public class Paciente {
    
    int codigo;
    String nome_pac;
    String fone;
    Date data_nasc;
    char sexo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome_pac() {
        return nome_pac;
    }

    public void setNome_pac(String nome_pac) {
        this.nome_pac = nome_pac;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
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

    public Paciente() {
    } 
    
    public Paciente(int codigo, String nome_pac, String fone, Date data_nasc, char sexo) {
        this.codigo = codigo;
        this.nome_pac = nome_pac;
        this.fone = fone;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
    }
    
}
