package Classes;

import java.util.Date;
import java.sql.Time;

public class Join_CMP {

    int id_consulta;
    String nome_med;
    String nome_pac;
    Date data;
    Time hora;
    char compareceu;

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getNome_med() {
        return nome_med;
    }

    public void setNome_med(String nome_med) {
        this.nome_med = nome_med;
    }

    public String getNome_pac() {
        return nome_pac;
    }

    public void setNome_pac(String nome_pac) {
        this.nome_pac = nome_pac;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public char getCompareceu() {
        return compareceu;
    }

    public void setCompareceu(char compareceu) {
        this.compareceu = compareceu;
    }

    public Join_CMP() {
    }

    public Join_CMP(int id_consulta, String nome_med, String nome_pac, Date data, Time hora, char compareceu) {
        this.id_consulta = id_consulta;
        this.nome_med = nome_med;
        this.nome_pac = nome_pac;
        this.data = data;
        this.hora = hora;
        this.compareceu = compareceu;
    }

}
