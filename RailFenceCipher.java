import java.util.Scanner;

public class RailFenceCipher {
    public static String encrypt(String plaintext, int rails) {
        StringBuilder ciphertext = new StringBuilder();
        char[][] rail = new char[rails][plaintext.length()];
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                rail[i][j] = 'X';  // Placeholder character
            }
        }
        int row = 0, col = 0;
        boolean down = true;
        for (int i = 0; i < plaintext.length(); i++) {
            rail[row][col++] = plaintext.charAt(i);
            if (row == 0 || row == rails - 1) {
                down = !down;
            }
            row = down ? row + 1 : row - 1;
        }
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (rail[i][j] != 'X') {
                    ciphertext.append(rail[i][j]);
                }
            }
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.print("Enter number of rails: ");
        int rails = sc.nextInt();
        
        String ciphertext = encrypt(plaintext, rails);
        System.out.println("Ciphertext: " + ciphertext);
    }
}
