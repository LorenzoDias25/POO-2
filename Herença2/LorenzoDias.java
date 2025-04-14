package heranca2;

import heranca2.Fisica2;
import heranca2.Juridica2;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class LorenzoDias {

    public static void main(String[] args) {
        boolean verify = true, teste;
        char op = 'a', opp = 'a', opg = 'a';
        String cp, aux;
        int cont, temp;
        String menu = "Menu:\n(C) Create\n(R) Read\n(U) Update\n(D) Delete\n(L) Leave";
        String menup = "Pessoa: \n(F) Fisica\n(J) Juridica";
        String menug = "Sexo: \n(M) Masculino\n(F) Feminino";
        String msg;
        
        ArrayList List = new ArrayList();
        
        do {
            
            do {
                
                try{
                    op = JOptionPane.showInputDialog(menu).charAt(0);
                    verify = false;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro, pressione enter para continuar");
                }

                }while(verify);
            
            switch (op) {
                case 'L':
                case 'l':{
                    JOptionPane.showMessageDialog(null, "Finalizando");
                } break;
                case 'C':
                case 'c': {
                    try {
                        opp = JOptionPane.showInputDialog(menup).charAt(0);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Erro, pressione enter para continuar");
                    }
                    switch (opp){
                        case 'F':
                        case 'f': {
                            try {
                                opg = JOptionPane.showInputDialog(menug).charAt(0);
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Erro, pressione enter para continuar");
                            }
                            switch(opg){
                                case 'M':
                                case 'm':{
                                    Homem homem = new Homem();
                                    try {
                                        homem.setNome(JOptionPane.showInputDialog("Nome: "));
                                        homem.setEndereco(JOptionPane.showInputDialog("Endereco: "));
                                        do {
                                        cp = JOptionPane.showInputDialog("CPF: ");
                                        if (!Verificador.verifica(cp, 1)){
                                            JOptionPane.showMessageDialog(null, "CPF Inválido, pressione enter para continuar");
                                        }
                                        }while(!Verificador.verifica(cp, 1));
                                        aux = cp;
                                        cp = "";
                                        temp = 0;
                                        for (cont = 0; cont < 14; cont++){
                                            if (cont == 3 || cont == 7){
                                                cp += ".";
                                            } else if (cont == 11){
                                                cp += "-";
                                            } else {
                                                cp += Character.getNumericValue(aux.charAt(temp));
                                                temp++;
                                            }
                                        }
                                        homem.setCpf(cp);
                                    } catch (Exception e){
                                        JOptionPane.showMessageDialog(null, "Erro, pressione enter para continuar");
                                    }
                                    List.add(homem);
                                }break;
                                case 'F': 
                                case 'f': {
                                    Mulher mulher = new Mulher();
                                    try {
                                        mulher.setNome(JOptionPane.showInputDialog("Nome: "));
                                        mulher.setEndereco(JOptionPane.showInputDialog("Endereco: "));
                                        do {
                                        cp = JOptionPane.showInputDialog("CPF: ");
                                        if (!Verificador.verifica(cp, 1)){
                                            JOptionPane.showMessageDialog(null, "CPF Inválido, pressione enter para continuar");
                                        }
                                        }while(!Verificador.verifica(cp, 1));
                                        aux = cp;
                                        cp = "";
                                        temp = 0;
                                        for (cont = 0; cont < 14; cont++){
                                            if (cont == 3 || cont == 7){
                                                cp += ".";
                                            } else if (cont == 11){
                                                cp += "-";
                                            } else {
                                                cp += Character.getNumericValue(aux.charAt(temp));
                                                temp++;
                                            }
                                        }
                                        mulher.setCpf(cp);
                                    } catch(Exception e){
                                        JOptionPane.showMessageDialog(null, "Erro, pressione enter para continuar");
                                    }
                                    List.add(mulher);
                                }break;
                                default:{
                                }
                            }
                        }break;
                        case 'J':
                        case 'j': {
                            Juridica2 juridica = new Juridica2();
                            try {
                                juridica.setNome(JOptionPane.showInputDialog("Nome: "));
                                juridica.setEndereco(JOptionPane.showInputDialog("Endereco: "));
                                juridica.setTipo(JOptionPane.showInputDialog("Tipo: "));
                                do {
                                    cp = JOptionPane.showInputDialog("CNPJ: ");
                                    if (!Verificador.verifica(cp, 0)){
                                        JOptionPane.showMessageDialog(null, "CNPJ Inválido, pressione enter para continuar");
                                    }
                                }while(!Verificador.verifica(cp, 0));
                                aux = cp;
                                cp = "";
                                temp = 0;
                                for (cont = 0; cont < 17; cont++){
                                    if (cont == 2 || cont == 6){
                                        cp += ".";
                                    } else if (cont == 10){
                                        cp += "/";
                                    }else if (cont == 15){
                                        cp += "-";
                                    } else {
                                        cp += Character.getNumericValue(aux.charAt(temp));
                                        temp++;
                                    }
                                }
                                juridica.setCnpj(cp);
                            } catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Erro, pressione enter para continuar");
                            }
                            List.add(juridica);
                        }break; 
                        default:{
                        }
                    }
                } break; 
                case 'R':
                case 'r': {
                    if (List.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
                    break;
                    }
                    msg = "Registros: ";
                    
                    for (cont = 0; cont < List.size();cont++){
                        if ((List.get(cont) instanceof Homem)){
                            Homem homem = new Homem();
                            homem = (Homem) List.get(cont);
                            msg = msg + "\nID: " + (cont + 1);
                            msg = msg + "\nNome: " + homem.getNome();
                            msg = msg + "\nEndereco: " + homem.getEndereco();
                            msg = msg + "\nSexo: " + homem.getSexo();
                            msg = msg + "\nCPF: " + homem.getCpf();
                            msg = msg + "\n___________________________________\n";
                        } else if ((List.get(cont) instanceof Mulher)){
                            Mulher mulher = new Mulher();
                            mulher = (Mulher) List.get(cont);
                            msg = msg + "\nID: " + (cont + 1);
                            msg = msg + "\nNome: " + mulher.getNome();
                            msg = msg + "\nEndereco: " + mulher.getEndereco();
                            msg = msg + "\nSexo: " + mulher.getSexo();
                            msg = msg + "\nCPF: " + mulher.getCpf();
                            msg = msg + "\n___________________________________\n";
                       } else {
                            Juridica2 juridica = new Juridica2();
                            juridica = (Juridica2) List.get(cont);
                            msg = msg + "\nID: " + (cont + 1);
                            msg = msg + "\nNome: " + juridica.getNome();
                            msg = msg + "\nEndereco: " + juridica.getEndereco();
                            msg = msg + "\nTipo: " + juridica.getTipo();
                            msg = msg + "\nCNPJ: " + juridica.getCnpj();
                            msg = msg + "\n___________________________________\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, msg);
                }break;
                case 'U':
                case 'u': {
                    if (List.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
                    break; 
                    }
                    
                    cont = Integer.parseInt(JOptionPane.showInputDialog("ID do registro: "));
                    
                    cont--;
                    
                    if (cont < 0 || cont >= List.size()){ 
                        break;
                    }
                    if (List.get(cont) instanceof Homem){
                        Homem homem = new Homem();
                        homem = (Homem) List.get(cont);
                        homem.setNome(JOptionPane.showInputDialog("Nome atual: " + homem.getNome()));
                        homem.setEndereco(JOptionPane.showInputDialog("Endereco atual: " + homem.getEndereco()));
                        homem.setCpf(JOptionPane.showInputDialog("CPF atual: " + homem.getCpf()));
                    } else if (List.get(cont) instanceof Mulher){
                        Mulher mulher = new Mulher();
                        mulher = (Mulher) List.get(cont);
                        mulher.setNome(JOptionPane.showInputDialog("Nome atual: " + mulher.getNome()));
                        mulher.setEndereco(JOptionPane.showInputDialog("Endereco atual: " + mulher.getEndereco()));
                        mulher.setCpf(JOptionPane.showInputDialog("CPF atual: " + mulher.getCpf()));
                    } else {
                        Juridica2 juridica = new Juridica2();
                        juridica = (Juridica2) List.get(cont);
                        juridica.setNome(JOptionPane.showInputDialog("Nome: "));
                        juridica.setEndereco(JOptionPane.showInputDialog("Endereco: "));
                        juridica.setTipo(JOptionPane.showInputDialog("Tipo: "));
                        juridica.setCnpj(JOptionPane.showInputDialog("CNPJ: "));
                    }
                }break;
                case 'D': 
                case 'd': {
                    if (List.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
                    break; 
                    }
                    
                    cont = Integer.parseInt(JOptionPane.showInputDialog("ID do registro: "));
                    
                    cont--;
                    
                    if (cont < 0 || cont >= List.size()){ 
                        break;
                    }
                    
                    List.remove(cont);
                }break;
                
                default:{
                    JOptionPane.showMessageDialog(null, "Opcao invalida !!!");
                }
            }
        } while (op != 'L' && op != 'l');
    }

}
