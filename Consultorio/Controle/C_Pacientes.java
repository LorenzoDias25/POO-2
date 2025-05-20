package Controle;

import Classes.Paciente;
import DAO.PacienteDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class C_Pacientes {

    public static void Listar(ArrayList<Paciente> Lista) {
        try {
            PacienteDAO PDAO = new PacienteDAO();
            Lista = PDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista de funcionarios no banco \n";
        int tamanho = Lista.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "Código: " + Lista.get(i).getCodigo();
                msg = msg + "\nNome: " + Lista.get(i).getNome_pac();
                msg = msg + " - Fone: " + Lista.get(i).getFone();
                msg = msg + " - Data de Nascimento: " + sdf.format(Lista.get(i).getData_nasc());
                msg = msg + " - Sexo: " + Lista.get(i).getSexo();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Inserir() {
        Paciente paciente = new Paciente();
        
        paciente.setNome_pac(JOptionPane.showInputDialog("Nome: "));
        paciente.setFone(JOptionPane.showInputDialog("Fone: "));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data de nascimento: ", "dd/mm/aaaa"));
            paciente.setData_nasc(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        paciente.setSexo(JOptionPane.showInputDialog("Sexo: ").charAt(0));

        PacienteDAO PDAO = new PacienteDAO();

        PDAO.inserir(paciente);

    }

    public static void Atualizar() {
        Paciente paciente = new Paciente();
        PacienteDAO PDAO = new PacienteDAO();
        int codigo;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo: "));
        paciente = PDAO.procurar(codigo);
        if (paciente != null) {
            paciente.setCodigo(codigo);
            paciente.setNome_pac(JOptionPane.showInputDialog(null, "Nome: ", paciente.getNome_pac()));
            paciente.setFone(JOptionPane.showInputDialog("Fone: ", paciente.getFone()));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Data de nascimento: ", sdf.format(paciente.getData_nasc())));
                paciente.setData_nasc(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            paciente.setSexo(JOptionPane.showInputDialog(null, "Sexo: ", paciente.getSexo()).charAt(0));
            PDAO.atualizar(paciente);

        } else {
            JOptionPane.showMessageDialog(null, "O(A) paciente com o codigo: " + codigo + " não foi localizada.");
        }

    }

    public static void Excluir() {

        Paciente paciente = new Paciente();
        PacienteDAO PDAO = new PacienteDAO();
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo: "));
        paciente = PDAO.procurar(codigo);
        if (paciente != null) {
            PDAO.excluir(paciente);
            JOptionPane.showMessageDialog(null, "O(A) paciente foi excluida com sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "O(A) paciente com o codigo informado não existe!!");
        }

    }
}
