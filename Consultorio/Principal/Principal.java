package Principal;

import ConexaoBD.ConexaoBD;
import Controle.C_Pacientes;
import Controle.C_Medicos;
import Controle.C_Consultas;
import Controle.C_Join;
import Classes.Paciente;
import Classes.Medico;
import Classes.Consulta;
import Classes.Join_CMP;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        
        ArrayList<Paciente> Paciente = new ArrayList<Paciente>();
        ArrayList<Medico> Medico = new ArrayList<Medico>();
        ArrayList<Consulta> Consulta = new ArrayList<Consulta>();
        ArrayList<Join_CMP> Join = new ArrayList<Join_CMP>();
        
        char op, menup, menum, menuc;
        String menu = "Menu "
                + "\n(P) Pacientes"
                + "\n(M) Medicos"
                + "\n(C) Consultas"
                + "\n(S) Sair";
        
        String pac = "Menu Pacientes"
                + "\n(A) Atualizar"
                + "\n(E) Excluir"
                + "\n(I) Inserir"
                + "\n(L) Listar"
                + "\n(V) Voltar";
        
        String med = "Menu Medicos"
                + "\n(A) Atualizar"
                + "\n(E) Excluir"
                + "\n(I) Inserir"
                + "\n(L) Listar"
                + "\n(V) Voltar";
        
        String con = "Menu Consultas"
                + "\n(A) Atualizar"
                + "\n(E) Excluir"
                + "\n(I) Inserir"
                + "\n(L) Listar"
                + "\n(S) Sair";
        ConexaoBD.dadosbd();
        
        do {
            op = JOptionPane.showInputDialog(menu).charAt(0);
            switch(op){
                case 'P': 
                case 'p': {
                        menup = JOptionPane.showInputDialog(pac).charAt(0);
                        switch(menup){
                        case 'L':
                        case 'l': {
                            C_Pacientes.Listar(Paciente);
                        }break;
                        case 'I': 
                        case 'i': {
                            C_Pacientes.Inserir();
                        }break;
                        case 'A': 
                        case 'a': {
                            C_Pacientes.Atualizar();
                        }break;
                        case 'E':
                        case 'e': {
                            C_Pacientes.Excluir();
                        }break;
                        case 'V':
                        case 'v': {
                        }break;
                        default: {
                            JOptionPane.showMessageDialog(null, "Opcao Invalida !!!");
                        }
                    }
                }break;
                case 'M': 
                case 'm': {
                    menum = JOptionPane.showInputDialog(med).charAt(0);
                    switch (menum){
                        case 'L':
                        case 'l': {
                            C_Medicos.Listar(Medico);
                        }break;
                        case 'I': 
                        case 'i': {
                            C_Medicos.Inserir();
                        }break;
                        case 'A': 
                        case 'a': {
                            C_Medicos.Atualizar();
                        }break;
                        case 'E':
                        case 'e': {
                            C_Medicos.Excluir();
                        }break;
                        case 'V':
                        case 'v': {
                        }break;
                        default: {
                            JOptionPane.showMessageDialog(null, "Opcao Invalida !!!");
                        }
                    }
                }break; 
                case 'C':
                case 'c': {
                    menuc = JOptionPane.showInputDialog(con).charAt(0);
                    switch (menuc){
                        case 'L':
                        case 'l': {
                            C_Join.Listar(Join);
                        }break;
                        case 'I': 
                        case 'i': {
                            C_Consultas.Inserir();
                        }break;
                        case 'A': 
                        case 'a': {
                            C_Consultas.Atualizar();
                        }break;
                        case 'E':
                        case 'e': {
                            C_Consultas.Excluir();
                        }break;
                        case 'V':
                        case 'v': {
                        }break;
                        default: {
                            JOptionPane.showMessageDialog(null, "Opcao Invalida !!!");
                        }
                    }
                }break; 
                case 'S': 
                case 's': {
                    JOptionPane.showMessageDialog(null, "Finalizando");
                }break;
                default: {
                
                }
            }
        }while(op != 'S' && op != 's');
    }
    
}
