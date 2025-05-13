package Controle;

import Classes.FuncionarioD;
import DAO.FDDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleFD {

    public static void Listartodos(ArrayList<FuncionarioD> Exercicio) {
        try {
            FDDAO FDAO = new FDDAO();
            Exercicio = FDAO.listartodos();
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista completa: \n";
        int tamanho = Exercicio.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID_func: " + Exercicio.get(i).getCodigo();
                msg = msg + "\nNome: " + Exercicio.get(i).getNome();
                msg = msg + " - Sexo: " + Exercicio.get(i).getSexo();
                msg = msg + " - Data de Nascimento: " + sdf.format(Exercicio.get(i).getData_nasc());
                msg = msg + " - CPF: " + Exercicio.get(i).getCpf();
                msg = msg + "\nID_dep: " + Exercicio.get(i).getID_dep();
                msg = msg + "\nNome: " + Exercicio.get(i).getNome_dep();
                msg = msg + " - Sexo: " + Exercicio.get(i).getSexo_dep();
                msg = msg + " - Data de Nascimento: " + sdf.format(Exercicio.get(i).getData_nasc_dep());
                msg = msg + " - ID_Func: " + Exercicio.get(i).getID_func();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }
    
    public static void Listarporfunc(ArrayList<FuncionarioD> Exercicio) {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do funcionario: "));
        
        try {
            FDDAO FDAO = new FDDAO();
            Exercicio = FDAO.listarporfunc(id);
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista por ID_func: \n";
        int tamanho = Exercicio.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID_func: " + Exercicio.get(i).getCodigo();
                msg = msg + "\nNome: " + Exercicio.get(i).getNome();
                msg = msg + " - Sexo: " + Exercicio.get(i).getSexo();
                msg = msg + " - Data de Nascimento: " + sdf.format(Exercicio.get(i).getData_nasc());
                msg = msg + " - CPF: " + Exercicio.get(i).getCpf();
                msg = msg + "\nID_ dep: " + Exercicio.get(i).getID_dep();
                msg = msg + "\nNome: " + Exercicio.get(i).getNome_dep();
                msg = msg + " - Sexo: " + Exercicio.get(i).getSexo_dep();
                msg = msg + " - Data de Nascimento: " + sdf.format(Exercicio.get(i).getData_nasc_dep());
                msg = msg + " - ID_Func: " + Exercicio.get(i).getID_func();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }
}
