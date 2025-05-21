package Controle;

import Classes.Consulta;
import DAO.ConsultaDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import javax.swing.JOptionPane;

public class C_Consultas {

    public static void Listar(ArrayList<Consulta> Lista) {
        try {
            ConsultaDAO CDAO = new ConsultaDAO();
            Lista = CDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista de consultas no banco \n";
        int tamanho = Lista.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            boolean aux;
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID consulta: " + Lista.get(i).getId_consulta();
                msg = msg + "\nID medico: " + Lista.get(i).getId_medico();
                msg = msg + " - ID paciente: " + Lista.get(i).getId_paciente();
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

    public static void Listardata(ArrayList<Consulta> Lista) {
        try {
            DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
            ConsultaDAO CDAO = new ConsultaDAO();
            Lista = CDAO.listardata(dtOutput.parse(JOptionPane.showInputDialog("Data: ", "dd/mm/aaaa")));

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
                msg = msg + "\nID Medico: " + Lista.get(i).getId_medico();
                msg = msg + " - ID Paciente: " + Lista.get(i).getId_paciente();
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
    
    public static void Inserir() {
        Consulta consulta = new Consulta();

        consulta.setId_medico(Integer.parseInt(JOptionPane.showInputDialog("ID Medico: ")));
        consulta.setId_paciente(Integer.parseInt(JOptionPane.showInputDialog("ID Paciente: ")));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data: ", "dd/mm/aaaa"));
            consulta.setData(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Time hora = null;
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");
        try {
            hora = new java.sql.Time(formato.parse(JOptionPane.showInputDialog("Hora: ", "hh:mm:ss")).getTime());
        } catch (Exception e) {
            System.out.println("Erro na conversão da hora");
        }
        consulta.setHora(hora);
        consulta.setCompareceu(JOptionPane.showInputDialog("Compareceu: ").charAt(0));
        ConsultaDAO CDAO = new ConsultaDAO();

        CDAO.inserir(consulta);

    }

    public static void Atualizar() {
        Consulta consulta = new Consulta();
        ConsultaDAO CDAO = new ConsultaDAO();
        int id;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Time hora = null;
        id = Integer.parseInt(JOptionPane.showInputDialog("ID consulta: "));

        consulta = CDAO.procurar(id);
        if (consulta != null) {
            consulta.setId_consulta(id);
            consulta.setId_medico(Integer.parseInt(JOptionPane.showInputDialog("ID Medico: ")));
            consulta.setId_paciente(Integer.parseInt(JOptionPane.showInputDialog("ID Paciente: ")));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data: ", "dd/mm/aaaa"));
                consulta.setData(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                hora = new java.sql.Time(formato.parse(JOptionPane.showInputDialog("Hora: ", "hh:mm:ss")).getTime());
            } catch (Exception e) {
                System.out.println("Erro na conversão da hora");
            }
            consulta.setHora(hora);
            consulta.setCompareceu(JOptionPane.showInputDialog("Compareceu: ").charAt(0));
            CDAO.atualizar(consulta);

        } else {
            JOptionPane.showMessageDialog(null, "A consulta com o Id: " + id + " não foi localizada.");
        }

    }

    public static void Excluir() {

        Consulta consulta = new Consulta();
        ConsultaDAO CDAO = new ConsultaDAO();
        int id;
        id = Integer.parseInt(JOptionPane.showInputDialog("Id Consulta: "));
        consulta = CDAO.procurar(id);
        if (consulta != null) {
            CDAO.excluir(consulta);
            JOptionPane.showMessageDialog(null, "A consulta foi excluida com sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "A consulta com o id informado não existe!!");
        }

    }
}
