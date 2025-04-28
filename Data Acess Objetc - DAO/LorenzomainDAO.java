
package lorenzoDAO.Main;

import javax.swing.JOptionPane;
import DAO.Classes.Lorenzo;
import java.util.ArrayList;

public class LorenzomainDAO {

    public static void main(String[] args) {
        ArrayList<Lorenzo> Agenda= new ArrayList<Lorenzo>();
        char op;
        String msg = "Menu\nI - Inserir\nL - Listar\nS - Sair";
        do {
            op = JOptionPane.showInputDialog(msg).charAt(0);
            
            switch (op){
                case 'l':
                case 'L': {
                    Controle.listarpessoas(Agenda);
                }break;
                case 'i': 
                case 'I': {
                    Controle.Inserir();
                }break;
                case 's': 
                case 'S': {
                    JOptionPane.showMessageDialog(null, "Finalizando");
                }break;
            }
        } while(op != 'S' && op != 's');
    }
    
}
