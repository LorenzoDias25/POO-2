package Controle;

import Classes.Join_CMP;
import DAO.Join_cmpDAO;
import DAO.MedicoDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class C_Join {

    public static void Listarmed(ArrayList<Join_CMP> Lista) {
        try {
            Join_cmpDAO JDAO = new Join_cmpDAO();
            Lista = JDAO.listarmed(Integer.parseInt(JOptionPane.showInputDialog("Id do médico: ")));
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        if (Lista.isEmpty()) {
            return;
        }
        String msg = "Lista de consulta no banco \n";
        int tamanho = Lista.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            boolean aux;
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID consulta: " + Lista.get(i).getId_consulta();
                msg = msg + "\nMedico: " + Lista.get(i).getNome_med();
                msg = msg + " - Paciente: " + Lista.get(i).getNome_pac();
                msg = msg + " - Data: " + sdf.format(Lista.get(i).getData());
                msg = msg + " - Hora: " + Lista.get(i).getHora();
                if (Lista.get(i).getCompareceu() == '1') {
                    aux = true;
                } else {
                    aux = false;
                }
                msg = msg + " - Compareceu: " + aux;
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Listarpac(ArrayList<Join_CMP> Lista) {
        try {
            Join_cmpDAO JDAO = new Join_cmpDAO();
            Lista = JDAO.listarpac(Integer.parseInt(JOptionPane.showInputDialog("Id do paciente: ")));
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        if (Lista.isEmpty()) {
            return;
        }
        String msg = "Lista de consulta no banco \n";
        int tamanho = Lista.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            boolean aux;
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID consulta: " + Lista.get(i).getId_consulta();
                msg = msg + "\nMedico: " + Lista.get(i).getNome_med();
                msg = msg + " - Paciente: " + Lista.get(i).getNome_pac();
                msg = msg + " - Data: " + sdf.format(Lista.get(i).getData());
                msg = msg + " - Hora: " + Lista.get(i).getHora();
                if (Lista.get(i).getCompareceu() == '1') {
                    aux = true;
                } else {
                    aux = false;
                }
                msg = msg + " - Compareceu: " + aux;
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    /*public static void Listardata(ArrayList<Join_CMP> Lista) { //Com join
        try {
            DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
            Join_cmpDAO JDAO = new Join_cmpDAO();
            Lista = JDAO.listardata(dtOutput.parse(JOptionPane.showInputDialog("Data: ", "dd/mm/aaaa")));

        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        if (Lista.isEmpty()) {
            return;
        }
        String msg = "Lista de consulta no banco \n";
        int tamanho = Lista.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            boolean aux;
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID consulta: " + Lista.get(i).getId_consulta();
                msg = msg + "\nMedico: " + Lista.get(i).getNome_med();
                msg = msg + " - Paciente: " + Lista.get(i).getNome_pac();
                msg = msg + " - Data: " + sdf.format(Lista.get(i).getData());
                msg = msg + " - Hora: " + Lista.get(i).getHora();
                if (Lista.get(i).getCompareceu() == '1') {
                    aux = true;
                } else {
                    aux = false;
                }
                msg = msg + " - Compareceu: " + aux;
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }*/
}
