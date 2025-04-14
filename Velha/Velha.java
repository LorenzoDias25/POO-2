package velha;

import javax.swing.JOptionPane;
import java.util.Random;

public class Velha {

    public static final int LINHA = 6;
    public static final int COLUNA = 6;

    public static void main(String[] args) {
        int temp, linha, coluna, vez, x= 0;
        char matriz[][] = new char[LINHA][COLUNA];
        String msg = "";
        Random rand = new Random();

        for (linha = 0; linha < LINHA; linha++) {
            if (linha > 0) {
                matriz[linha][0] = (char) (linha + '0');
                msg += matriz[linha][0];
            }
            for (coluna = 1; coluna < COLUNA; coluna++) {
                switch (linha) {
                    case 0: {
                        matriz[linha][coluna] = (char) (coluna + '0');
                    }
                    break;
                    case 1: {
                        if (coluna == 2 || coluna == 4) {
                            matriz[linha][coluna] = '|';
                        } else {
                            matriz[linha][coluna] = ' ';
                        }
                    }
                    break;
                    case 2: {
                        matriz[linha][coluna] = '-';
                    }
                    break;
                    case 3: {
                        if (coluna == 2 || coluna == 4) {
                            matriz[linha][coluna] = '|';
                        } else {
                            matriz[linha][coluna] = ' ';
                        }
                    }
                    break;
                    case 4: {
                        matriz[linha][coluna] = '-';
                    }
                    break;
                    case 5: {
                        if (coluna == 2 || coluna == 4) {
                            matriz[linha][coluna] = '|';
                        } else {
                            matriz[linha][coluna] = ' ';
                        }
                    }
                    break;
                }

                if (linha == 0) {
                    msg += "    ";
                } else {
                    msg += "    ";
                }
                msg += matriz[linha][coluna];
            }
            msg += "\n";
        }
        JOptionPane.showMessageDialog(null, "Sorteio para primeira jogada: \nX = par\nO = impar\nPressione enter para comecar");
        temp = rand.nextInt(2);
        JOptionPane.showMessageDialog(null, "Resultado do sorteio: " + temp);
        vez = temp;
        for (temp = 0; temp < 8; temp++) {
            if (vez == 0) {
                do {
                    linha = Integer.parseInt(JOptionPane.showInputDialog("Vez do jogador X\n" + msg + "Linha: "));
                } while (linha >= LINHA || linha < 1);
                do {
                    coluna = Integer.parseInt(JOptionPane.showInputDialog("Vez do jogador X\n" + msg + "Coluna: "));
                } while (coluna >= COLUNA || coluna < 1);

                if (matriz[linha][coluna] == ' ' && matriz[linha][coluna] != 'X' && matriz[linha][coluna] != 'O') {
                    matriz[linha][coluna] = 'X';
                    vez = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Posicao ocupada");
                }
            } else {
                do {
                    linha = Integer.parseInt(JOptionPane.showInputDialog("Vez do jogador O\n" + msg + "Linha: "));
                } while (linha >= LINHA || linha < 1);
                do {
                    coluna = Integer.parseInt(JOptionPane.showInputDialog("Vez do jogador O\n" + msg + "Coluna: "));
                } while (coluna >= COLUNA || coluna < 1);
                if (matriz[linha][coluna] == ' ' && matriz[linha][coluna] != 'X' && matriz[linha][coluna] != 'O') {
                    matriz[linha][coluna] = 'O';
                    vez = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Posicao ocupada");
                }
            }

            msg = "";

            for (linha = 0; linha < LINHA; linha++) {
                for (coluna = 0; coluna < COLUNA; coluna++) {
                    if (linha == 0) {
                        msg += "    ";
                    } else {
                        msg += "    ";
                    }
                    msg += matriz[linha][coluna];
                }
                msg += "\n";
            }

            if (matriz[1][1] == 'X' && matriz[1][3] == 'X' && matriz[1][5] == 'X') { // reta cima
                vez = 0;
                break;
            } else if (matriz[3][1] == 'X' && matriz[3][3] == 'X' && matriz[3][5] == 'X') { // reta meio
                vez = 0;
                break;
            } else if (matriz[5][1] == 'X' && matriz[5][3] == 'X' && matriz[5][5] == 'X') { // reta cima
                vez = 0;
                break;
            } else if (matriz[1][1] == 'X' && matriz[3][1] == 'X' && matriz[5][1] == 'X') { // reta esquerda
                vez = 0;
                break;
            } else if (matriz[1][3] == 'X' && matriz[3][3] == 'X' && matriz[5][3] == 'X') { // reta meio cima baixo
                vez = 0;
                break;
            } else if (matriz[1][5] == 'X' && matriz[3][5] == 'X' && matriz[5][5] == 'X') { // reta direita
                vez = 0;
                break;
            } else if (matriz[1][1] == 'X' && matriz[3][3] == 'X' && matriz[5][5] == 'X') { // reta esquerda
                vez = 0;
                break;
            } else if (matriz[1][5] == 'X' && matriz[3][3] == 'X' && matriz[5][1] == 'X') { // reta esquerda
                vez = 0;
                break;
            }

            if (matriz[1][1] == 'O' && matriz[1][3] == 'O' && matriz[1][5] == 'O') { // reta cima
                vez = 0;
                break;
            } else if (matriz[3][1] == 'O' && matriz[3][3] == 'O' && matriz[3][5] == 'O') { // reta meio
                vez = 0;
                break;
            } else if (matriz[5][1] == 'O' && matriz[5][3] == 'O' && matriz[5][5] == 'O') { // reta cima
                vez = 0;
                break;
            } else if (matriz[1][1] == 'O' && matriz[3][1] == 'O' && matriz[5][1] == 'O') { // reta esquerda
                vez = 0;
                break;
            } else if (matriz[1][3] == 'O' && matriz[3][3] == 'O' && matriz[5][3] == 'O') { // reta meio cima baixo
                vez = 0;
                break;
            } else if (matriz[1][5] == 'O' && matriz[3][5] == 'O' && matriz[5][5] == 'O') { // reta direita
                vez = 0;
                break;
            } else if (matriz[1][1] == 'O' && matriz[3][3] == 'O' && matriz[5][5] == 'O') { // reta esquerda
                vez = 0;
                break;
            } else if (matriz[1][5] == 'O' && matriz[3][3] == 'O' && matriz[5][1] == 'O') { // reta esquerda
                vez = 0;
                break;
            }
        }
        switch (vez) {
            case 0:
                    JOptionPane.showMessageDialog(null, "X venceu\n" + msg);
                break;
            case 1:
                    JOptionPane.showMessageDialog(null, "O venceu\n" + msg);
                break;
            default:
                    JOptionPane.showMessageDialog(null, "Empate\n" + msg);
                break;
        }
    }

}
