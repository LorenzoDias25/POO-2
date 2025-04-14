package heranca2;

public class Verificador {

    
    public static boolean verifica(String cp, int op) {

        int n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13;
        int soma1, soma2, resto1, resto2;

        if (op == 1) {
            n0 = Character.getNumericValue(cp.charAt(0));
            n1 = Character.getNumericValue(cp.charAt(1));
            n2 = Character.getNumericValue(cp.charAt(2));
            n3 = Character.getNumericValue(cp.charAt(3));
            n4 = Character.getNumericValue(cp.charAt(4));
            n5 = Character.getNumericValue(cp.charAt(5));
            n6 = Character.getNumericValue(cp.charAt(6));
            n7 = Character.getNumericValue(cp.charAt(7));
            n8 = Character.getNumericValue(cp.charAt(8));
            n9 = Character.getNumericValue(cp.charAt(9));
            n10 = Character.getNumericValue(cp.charAt(10));

            soma1 = (n0 * 10) + (n1 * 9) + (n2 * 8) + (n3 * 7) + (n4 * 6) + (n5 * 5) + (n6 * 4) + (n7 * 3) + (n8 * 2);
            resto1 = (soma1 * 10) % 11;
            System.out.println("Soma1 : " + soma1+ "\nResto1: " + resto1+ "\nN9: " + n9);
            if (resto1 == n9) {
                soma2 = (n0 * 11) + (n1 * 10) + (n2 * 9) + (n3 * 8) + (n4 * 7) + (n5 * 6) + (n6 * 5) + (n7 * 4) + (n8 * 3) + (n9 * 2);
                resto2 = (soma2 * 10) % 11;
                System.out.printf("Soma1: %d\nResto1: %d\nSoma2: %d\nResto2: %d", soma1,resto1,soma2,resto2);
            } else if (resto1 == 10 && n9 == 0) {
                soma2 = (n0 * 11) + (n1 * 10) + (n2 * 9) + (n3 * 8) + (n4 * 7) + (n5 * 6) + (n6 * 5) + (n7 * 4) + (n8 * 3) + (n9 * 2);
                resto2 = (soma2 * 10) % 11;
                System.out.printf("Soma1: %d\nResto1: %d\nSoma2: %d\nResto2: %d", soma1,resto1,soma2,resto2);
            } else {
                return false;
            }
            if (resto2 == n10) {
                System.out.println("CPF Válido");
                return true;
            }
        } else {
            n0 = Character.getNumericValue(cp.charAt(0));
            n1 = Character.getNumericValue(cp.charAt(1));
            n2 = Character.getNumericValue(cp.charAt(2));
            n3 = Character.getNumericValue(cp.charAt(3));
            n4 = Character.getNumericValue(cp.charAt(4));
            n5 = Character.getNumericValue(cp.charAt(5));
            n6 = Character.getNumericValue(cp.charAt(6));
            n7 = Character.getNumericValue(cp.charAt(7));
            n8 = Character.getNumericValue(cp.charAt(8));
            n9 = Character.getNumericValue(cp.charAt(9));
            n10 = Character.getNumericValue(cp.charAt(10));
            n11 = Character.getNumericValue(cp.charAt(11));
            n12 = Character.getNumericValue(cp.charAt(12));
            n13 = Character.getNumericValue(cp.charAt(13));

            soma1 = (n0 * 5) + (n1 * 4) + (n2 * 3) + (n3 * 2) + (n4 * 9) + (n5 * 8) + (n6 * 7) + (n7 * 6) + (n8 * 5) + (n9 * 4) + (n10 * 3) + (n11 * 2);
            resto1 = soma1 % 11;

            if (resto1 > 2) {
                resto1 = 11 - resto1;
            } else {
                resto1 = 0;
            }
            soma2 = (n0 * 6) + (n1 * 5) + (n2 * 4) + (n3 * 3) + (n4 * 2) + (n5 * 9) + (n6 * 8) + (n7 * 7) + (n8 * 6) + (n9 * 5) + (n10 * 4) + (n11 * 3) + (resto1 * 2);
            resto2 = soma2 % 11;
            if (resto2 > 2) {
                resto2 = 11 - resto2;
            } else {
                resto2 = 0;
            }
            if (resto1 == n12 && resto2 == n13) {
                System.out.println("CNPJ Valido");
                return true;
            }
        }
        return false;
    }
}
