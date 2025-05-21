package Controle;

import Classes.Medico;
import DAO.MedicoDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class C_Medicos {

    public static void Listar(ArrayList<Medico> Lista) {
        try {
            MedicoDAO MDAO = new MedicoDAO();
            Lista = MDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista de medicos no banco \n";
        int tamanho = Lista.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID: " + Lista.get(i).getId();
                msg = msg + "\nNome: " + Lista.get(i).getNome_med();
                msg = msg + " - Especialidade: " + Lista.get(i).getEspecialidade();
                msg = msg + " - Data de Nascimento: " + sdf.format(Lista.get(i).getData_nasc());
                msg = msg + " - Sexo: " + Lista.get(i).getSexo();
                msg = msg + " - Fone: " + Lista.get(i).getFone();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Inserir() {
        Medico medico = new Medico();

        medico.setNome_med(JOptionPane.showInputDialog("Nome: "));
        medico.setEspecialidade(JOptionPane.showInputDialog("Especialidade: "));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data de nascimento: ", "dd/mm/aaaa"));
            medico.setData_nasc(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        medico.setSexo(JOptionPane.showInputDialog("Sexo: ").charAt(0));
        medico.setFone(JOptionPane.showInputDialog("Fone: "));
        MedicoDAO MDAO = new MedicoDAO();

        MDAO.inserir(medico);

    }

    public static void Atualizar() {
        Medico medico = new Medico();
        MedicoDAO MDAO = new MedicoDAO();
        int id;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
        medico = MDAO.procurar(id);
        if (medico != null) {
            medico.setId(id);
            medico.setNome_med(JOptionPane.showInputDialog(null, "Nome: ", medico.getNome_med()));
            medico.setEspecialidade(JOptionPane.showInputDialog(null, "Especialidade: ", medico.getEspecialidade()));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Data de nascimento: ", sdf.format(medico.getData_nasc())));
                medico.setData_nasc(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            medico.setSexo(JOptionPane.showInputDialog(null, "Sexo: ", medico.getSexo()).charAt(0));
            medico.setFone(JOptionPane.showInputDialog("Fone: ", medico.getFone()));
            MDAO.atualizar(medico);

        } else {
            JOptionPane.showMessageDialog(null, "O(A) paciente com o Id: " + id + " não foi localizada.");
        }

    }

    public static void Excluir() {

        Medico medico = new Medico();
        MedicoDAO MDAO = new MedicoDAO();
        int id;
        id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        medico = MDAO.procurar(id);
        if (medico != null) {
            MDAO.excluir(medico);
            JOptionPane.showMessageDialog(null, "O(A) medico foi excluida com sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "O(A) medico com o codigo informado não existe!!");
        }

    }
}
