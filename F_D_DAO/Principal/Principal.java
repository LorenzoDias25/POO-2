package Principal;

import Util.ConexaoBD;
import Controle.ControleF;
import Controle.ControleD;
import Controle.ControleFD;
import Classes.Funcionario;
import Classes.Dependente;
import Classes.FuncionarioD;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        ArrayList<Funcionario> funci = new ArrayList<Funcionario>();
        ArrayList<Dependente> depe = new ArrayList<Dependente>();
        ArrayList<FuncionarioD> FD = new ArrayList<FuncionarioD>();
        
        char opcao, aux;
        ConexaoBD.dadosbd();
        String msg = "Menu\n(F) Funcionario\n(D) Dependente\n(J) Join\n(S) Sair";
        String func = "Menu Funcionario\n(L) Listar\n(I) Inserir\n(A) Atualizar\n(E) Excluir";
        String dep = "Menu Dependente\n(L) Listar\n(I) Inserir\n(A) Atualizar\n(E) Excluir";
        String join = "Menu Join \n(T) Listar Todos\n(F) Listar por Funcionario";
        do {
            opcao = JOptionPane.showInputDialog(msg).charAt(0);
            switch (opcao) {
                case 'f':
                case 'F': {
                    aux = JOptionPane.showInputDialog(func).charAt(0);
                    switch (aux){
                        case 'l':
                        case 'L': {
                            ControleF.Listar(funci);
                        }break;
                        case 'i':
                        case 'I': {
                            ControleF.Inserir();
                        }break;
                        case 'a':
                        case 'A': {
                            ControleF.Atualizar();
                        }break;
                        case 'e':
                        case 'E': {
                            ControleF.Excluir();
                        }break;
                    }
                }break;
                case 'd':
                case 'D': {
                    aux = JOptionPane.showInputDialog(dep).charAt(0);
                    switch(aux){
                        case 'l':
                        case 'L': {
                            ControleD.Listar(depe);
                        }break;
                        case 'i':
                        case 'I': {
                            ControleD.Inserir();
                        }break;
                        case 'a': 
                        case 'A': {
                            ControleD.Atualizar();
                        }break;
                        case 'e': 
                        case 'E': {
                            ControleD.Excluir();
                        }break;
                    }
                }break;
                case 'j':
                case 'J': {
                    aux = JOptionPane.showInputDialog(join).charAt(0);
                    switch(aux){
                        case 't':
                        case 'T': {
                            ControleFD.Listartodos(FD);
                        }break;
                        case 'f':
                        case 'F': {
                            ControleFD.Listarporfunc(FD);
                        }break;
                    }
                }break; 
                case 's':
                case 'S': {
                    JOptionPane.showMessageDialog(null, "Finalizando");
                }
                break;
                default: {
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                }
            }

        } while (opcao != 's');

    }

}
