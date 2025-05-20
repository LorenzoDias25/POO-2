
package Classes;

import java.sql.Time;
import java.util.Date;

public class Consulta {
    
    int id_consulta;
    int id_medico;
    int id_paciente;
    Date data;
    Time hora;
    char compareceu;

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
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

    public Consulta() {
    }

    public Consulta(int id_consulta, int id_medico, int id_paciente, Date data, Time hora, char compareceu) {
        this.id_consulta = id_consulta;
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.data = data;
        this.hora = hora;
        this.compareceu = compareceu;
    }
    
    
}
