
package lorenzoDAO.Main;

import DAO.Classes.Lorenzo;
import DAO.DAO.LorenzoDAO;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controle {
    
    public static void listarpessoas(ArrayList<Lorenzo> Agenda){
        try {
            LorenzoDAO x = new LorenzoDAO();
            Agenda = x.listar();
        } catch (Exception e){
            System.out.println("problema");
        }
        String msg = "Lista de pessoas da agenda \n";
        int tamanho = Agenda.size();
        Lorenzo lorenzo = new Lorenzo();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if (tamanho == 0){
            JOptionPane.showMessageDialog(null, "Agenda Vazia !!");
        } else {
            for (int i = 0; i < tamanho; i++){
                
                msg += "Posiçao: " + i;
                msg += "\nNome: " + Agenda.get(i).getNome();
                msg += "\nSexo: " + Agenda.get(i).getSexo();
                msg += "\nData de nascimento: " + sdf.format(Agenda.get(i).getDataNasc());
                msg += "\nNacionalidade: " + Agenda.get(i).getNacionalidade();
                msg += "\n____________________________________________________\n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }
    
    public static void Inserir(){
        Lorenzo lorenzo= new Lorenzo();
        
        lorenzo.setNome(JOptionPane.showInputDialog("Nome: "));
        lorenzo.setSexo(JOptionPane.showInputDialog("Sexo: ").charAt(0));
        DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date dt = dtOutput.parse(JOptionPane.showInputDialog("Data de nascimento: "));
            lorenzo.setDataNasc(dt);
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        lorenzo.setNacionalidade(JOptionPane.showInputDialog("Nacionalidade: "));
        
        LorenzoDAO ldao = new LorenzoDAO();
        
        ldao.inserir(lorenzo);
    }
}
