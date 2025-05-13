package Controle;

import Classes.Dependente;
import DAO.DependenteDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControleD {
    public static void Listar(ArrayList<Dependente> Exercicio) {
        try {
            DependenteDAO DepDAO = new DependenteDAO();
            Exercicio = DepDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista de dependentes no banco: \n";
        int tamanho = Exercicio.size();
        DependenteDAO DepDAO = new DependenteDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "ID: " + Exercicio.get(i).getID_dep();
                msg = msg + "\nNome: " + Exercicio.get(i).getNome_dep();
                msg = msg + " - Sexo: " + Exercicio.get(i).getSexo_dep();
                msg = msg + " - Data de Nascimento: " + sdf.format(Exercicio.get(i).getData_nasc_dep());
                msg = msg + " - ID_Func: " + Exercicio.get(i).getID_func();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Inserir() {
        Dependente dep = new Dependente();

        dep.setNome_dep(JOptionPane.showInputDialog("Nome: "));
        dep.setSexo_dep(JOptionPane.showInputDialog("Sexo: ").charAt(0));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data de nascimento: "));
            dep.setData_nasc_dep(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dep.setID_func(Integer.parseInt(JOptionPane.showInputDialog(null, "ID_func: ", dep.getID_func())));
        DependenteDAO DepDAO = new DependenteDAO();

        DepDAO.inserir(dep);

    }

    public static void Atualizar() {
        Dependente dep = new Dependente();
        DependenteDAO DepDAO = new DependenteDAO();
        int codigo;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo: "));
        dep = DepDAO.procurar(codigo);
        if (dep != null) {
            dep.setID_dep(codigo);
            dep.setNome_dep(JOptionPane.showInputDialog(null, "Nome: ", dep.getNome_dep()));
            dep.setSexo_dep(JOptionPane.showInputDialog(null, "Sexo: ", dep.getSexo_dep()).charAt(0));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Data de nascimento: ", sdf.format(dep.getData_nasc_dep())));
                dep.setData_nasc_dep(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            dep.setID_func(Integer.parseInt(JOptionPane.showInputDialog(null, "ID_func: ", dep.getID_func())));
            DepDAO.atualizar(dep);

        } else {
            JOptionPane.showMessageDialog(null, "O(A) dependente com o ID: " + codigo + " não foi localizada(o).");
        }

    }

    public static void Excluir() {

        Dependente dep = new Dependente();
        DependenteDAO DepDAO = new DependenteDAO();
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
        dep = DepDAO.procurar(codigo);
        if (dep != null) {
            DepDAO.excluir(dep);
            JOptionPane.showMessageDialog(null, "O(A) dependete foi excluida com sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "O(A) dependente com o id informado não existe!!");
        }

    }
}
