
package DAO.Classes;

import java.util.Date;

public class Lorenzo implements java.io.Serializable {
    int ID_Pessoa;
    String nome;
    char sexo;
    Date dataNasc;
    String nacionalidade;

    public int getID_Pessoa() {
        return ID_Pessoa;
    }

    public void setID_Pessoa(int ID_Pessoa) {
        this.ID_Pessoa = ID_Pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    public Lorenzo(){
    }
    
    public Lorenzo(int ID_Pessoa, String nome, char sexo, Date dataNasc, String nacionalidade){
        this.ID_Pessoa = ID_Pessoa;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.nacionalidade = nacionalidade;
    }
}
