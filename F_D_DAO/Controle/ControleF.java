package Controle;

import Classes.Funcionario;
import DAO.FuncionarioDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControleF {

    public static void Listar(ArrayList<Funcionario> Exercicio) {
        try {
            FuncionarioDAO FDAO = new FuncionarioDAO();
            Exercicio = FDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema" + ex);
        }
        String msg = "Lista de funcionarios no banco \n";
        int tamanho = Exercicio.size();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tamanho == 0) {
            JOptionPane.showMessageDialog(null, "Banco Vazio !!");
        } else {
            for (int i = 0; i < tamanho; i++) {

                msg = msg + "Código: " + Exercicio.get(i).getCodigo();
                msg = msg + "\nNome: " + Exercicio.get(i).getNome();
                msg = msg + " - Sexo: " + Exercicio.get(i).getSexo();
                msg = msg + " - Data de Nascimento: " + sdf.format(Exercicio.get(i).getData_nasc());
                msg = msg + " - CPF: " + Exercicio.get(i).getCpf();
                msg = msg + "\n___________________________________________________ \n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public static void Inserir() {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(JOptionPane.showInputDialog("Nome: "));
        funcionario.setSexo(JOptionPane.showInputDialog("Sexo: ").charAt(0));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data de nascimento: "));
            funcionario.setData_nasc(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        funcionario.setCpf(JOptionPane.showInputDialog("CPF: "));

        FuncionarioDAO FDAO = new FuncionarioDAO();

        FDAO.inserir(funcionario);

    }

    public static void Atualizar() {
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO FDAO = new FuncionarioDAO();
        int codigo;
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo: "));
        funcionario = FDAO.procurar(codigo);
        if (funcionario != null) {
            funcionario.setCodigo(codigo);
            funcionario.setNome(JOptionPane.showInputDialog(null, "Nome: ", funcionario.getNome()));
            funcionario.setSexo(JOptionPane.showInputDialog(null, "Sexo: ", funcionario.getSexo()).charAt(0));
            try {
                Date dt = dtOutput.parse(JOptionPane.showInputDialog(null, "Data de nascimento: ", sdf.format(funcionario.getData_nasc())));
                funcionario.setData_nasc(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            funcionario.setCpf(JOptionPane.showInputDialog(null, "Cpf: ", funcionario.getCpf()));
            FDAO.atualizar(funcionario);

        } else {
            JOptionPane.showMessageDialog(null, "A pessoa com o codigo " + codigo + " não foi localizada.");
        }

    }

    public static void Excluir() {

        Funcionario funcionario = new Funcionario();
        FuncionarioDAO FDAO = new FuncionarioDAO();
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo: "));
        funcionario = FDAO.procurar(codigo);
        if (funcionario != null) {
            FDAO.excluir(funcionario);
            JOptionPane.showMessageDialog(null, "O(A) funcionario(a) foi excluida com sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "O(A) funcionario(a) com o codigo informado não existe!!");
        }

    }
}
